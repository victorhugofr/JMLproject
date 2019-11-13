package br.com.sigcar.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.dominio.Documento;
import br.com.sigcar.repositorios.ContestacaoRepositorio;
import br.com.sigcar.repositorios.DocumentoRepositorio;

@Named("documentoMBean")
@SessionScoped
public class DocumentoMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Documento documento;
	
	private String contestacao;
	
	@Inject
	private DocumentoRepositorio documentoRepositorio;
	
	private Part arquivo;

	public void salvar() {
		documentoRepositorio.salvar(documento);
	}
	
	public String salvar(Documento documento) {
		documentoRepositorio.salvar(documento);
		return null;
	}
	
	public String download(Documento documento) {
		Documento documentoBd = documentoRepositorio.getDocumento(documento.getNome());
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-Disposition", "attachment; filename="+documentoBd.getNome()+"siac."+documentoBd.getExtensao());
		response.setContentType("application/octet-stream");
		response.setContentLength(documentoBd.getArquivoBase64Original().length);
		try {
			response.getOutputStream().write(documento.getArquivoBase64Original());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}
	
	public void contestar(Documento documento) {
		Contestacao contestacaoOb = new Contestacao();
		contestacaoOb.setTexto(contestacao);
		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		contestacaoRepositorio.salvar(contestacaoOb);
		try {
			documento.getContestacao().add(contestacaoOb);
		}catch(NullPointerException e) {
			List<Contestacao> contestacoes = new ArrayList<Contestacao>();
			contestacoes.add(contestacaoOb);
			documento.setContestacao(contestacoes);
		}
		documentoRepositorio.salvar(documento);
	}
	public DocumentoMBean() {
		documento = new Documento();
	}
	
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContestacao() {
		return contestacao;
	}

	public void setContestacao(String contestacao) {
		this.contestacao = contestacao;
	}
}
