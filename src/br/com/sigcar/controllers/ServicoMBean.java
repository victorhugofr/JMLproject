package br.com.sigcar.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.DatatypeConverter;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.dominio.Servico;
import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.enums.StatusDocumento;
import br.com.sigcar.enums.TipoServico;
import br.com.sigcar.repositorios.DocumentoRepositorio;
import br.com.sigcar.repositorios.ServicoRepositorio;

@Named("servicoMBean")
@SessionScoped
public class ServicoMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicoRepositorio servicoRepositorio;
	
	@Inject
	private DocumentoRepositorio documentoRepositorio;
	
	private Servico servico;
	
	private Servico servicoAcompanhar;
	
	private Servico servicoCorrigir;
	
	private DataModel<Servico> servicosModel;
	
	private Usuario usuario;
	
	private UploadedFile arquivo;
	
	private List<Documento> documentos;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ServicoMBean() {
		servico=new Servico();
		usuario=new Usuario();
		documentos = new ArrayList<Documento>();
		servicoAcompanhar= new Servico();
		servicoCorrigir= new Servico();
	}
	public String listarServicos() {
		servicosModel = new ListDataModel<Servico>(servicoRepositorio.listarServicos());

		return "/pages/servicos/list.jsf?faces-redirect=true";
	}
	
	public String abrirServico(){
		Servico servicoBd = servicoRepositorio.getServico(servico.getNomeEntidade());
		
		if(servicoBd == null) { //alterar depois, tem um bug, pois um usuario pode ter varios servicos para uma mesma entidade
			for(int i=0;i<documentos.size();i++) {
				documentoRepositorio.salvar(documentos.get(i));
			}
			if(documentos==null) {
				FacesMessage msg = new FacesMessage("Insira um documento","");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}
			servico.setDocumentos(documentos);
			servico.setStatus(true);
			servicoRepositorio.salvar(servico);
			servico=new Servico();
			servicoBd=null;
			FacesMessage msg = new FacesMessage("Servico aberto com sucesso","");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			return "/pages/index.jsf?faces-redirect=true";
		}else {
			FacesMessage msg = new FacesMessage("Servico ja est� aberto","");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}
	
	public String acompanharServico(Servico servico) {
		servicoAcompanhar=servico;
		return "/pages/servicos/acompanhar.jsf?faces-redirect=true";
	}
	
	public String corrigirServico(Servico servico) {
		servicoCorrigir=servico;
		return "/pages/servicos/corrigir.jsf?faces-redirect=true";
	}

	public void handleFileUpload(FileUploadEvent event) {
		byte[] arquivoByte = null;
		arquivo=event.getFile();
		if(arquivo==null) {
			FacesMessage msg = new FacesMessage("Insira um arquivo","");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}else {
			FacesMessage msg = new FacesMessage("Arquivo adicionado com sucesso","");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		try {
			arquivoByte = getByte(event.getFile().getInputstream());
		} catch (IOException e) {
			FacesMessage msg = new FacesMessage("Erro interno","");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		Documento documento = new Documento();
		documento.setArquivoBase64Original(arquivoByte);
		documento.setExtensao(arquivo.getContentType().split("\\/")[1]);
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		String miniArquivo = "data:"+arquivo.getContentType()+";base64,"+DatatypeConverter.printBase64Binary(baos.toByteArray());
		documento.setArquivoBase64(miniArquivo);
		documento.setNome(arquivo.getFileName());
		documento.setStatus(StatusDocumento.AGUARDANDO_CORRECAO);
		documentos.add(documento);
	}
	
	public StatusDocumento[] getStatusDocumento(){
		return StatusDocumento.values();
	}
	
	public TipoServico[] getTipoServico() {
		return TipoServico.values();
	}
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public DataModel<Servico> getServicosModel() {
		return servicosModel;
	}

	public void setServicosModel(DataModel<Servico> servicosModel) {
		this.servicosModel = servicosModel;
	}
	public UploadedFile getArquivo() {
		return arquivo;
	}
	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}
	
	/*metodo que converte inputstream para array de bytes*/
	private byte[] getByte(InputStream is) {
		int len;
		int size = 1024;
		byte[] buffer=null;
		if(is instanceof ByteArrayInputStream) {
			try {
				size=is.available();
				buffer=new byte[size];
				len=is.read(buffer, 0, size);
			} catch (IOException e) {
				FacesMessage msg = new FacesMessage("Erro interno","");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buffer=new byte[size];
			try {
				while((len=is.read(buffer, 0, size))!= -1) {
					bos.write(buffer, 0, len);
				}
			} catch (IOException e) {
				FacesMessage msg = new FacesMessage("Erro interno","");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			buffer=bos.toByteArray();
		}
		return buffer;
	}
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	public Servico getServicoAcompanhar() {
		return servicoAcompanhar;
	}
	public void setServicoAcompanhar(Servico servicoAcompanhar) {
		this.servicoAcompanhar = servicoAcompanhar;
	}
	public Servico getServicoCorrigir() {
		return servicoCorrigir;
	}
	public void setServicoCorrigir(Servico servicoCorrigir) {
		this.servicoCorrigir = servicoCorrigir;
	}
}
