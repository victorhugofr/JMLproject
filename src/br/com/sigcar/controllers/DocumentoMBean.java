package br.com.sigcar.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
	
	private DocumentoRepositorio documentoRepositorio;
	
	private Part arquivo;

	public DocumentoMBean() {
		documento = new Documento();
		documentoRepositorio = new DocumentoRepositorio();
	}
	
	/*@ 
	@ 	requires documento2 != null;
	@   requires documentoRepositorio != null;
	@*/
	public void salvar() {
		documentoRepositorio.salvar(documento);
	}
	
	/*@ 
	@ 	requires documento2 != null;
	@   requires documentoRepositorio != null;
	@*/
	
	public String salvar(Documento documento) {
		documentoRepositorio.salvar(documento);
		return null;
	}
	
	public String download(Documento documento2) {
		Documento documentoBd = documentoRepositorio.getDocumento(documento2.getNome());
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-Disposition", "attachment; filename="+documentoBd.getNome()+"siac."+documentoBd.getExtensao());
		response.setContentType("application/octet-stream");
		response.setContentLength(documentoBd.getArquivoBase64Original().length);
		try {
			response.getOutputStream().write(documento2.getArquivoBase64Original());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}
	
	/*@ 
	@ 	requires documento2 != null;
	@   requires documentoRepositorio != null;
	@*/
	public void contestar(Documento documento2) {
		Contestacao contestacaoOb = new Contestacao();
		contestacaoOb.setTexto(contestacao);
		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		contestacaoRepositorio.salvar(contestacaoOb);
		try {
			documento2.getContestacao().add(contestacaoOb);
		}catch(NullPointerException e) {
			List<Contestacao> contestacoes = new ArrayList<Contestacao>();
			contestacoes.add(contestacaoOb);
			documento2.setContestacao(contestacoes);
		}
		documentoRepositorio.salvar(documento2);
	}
	
	public Documento getDocumento() {
		return documento;
	}

	/*@ 
	@ 	requires documento2 != null;
	@*/
	public void setDocumento(Documento documento2) {
		this.documento = documento2;
	}

	public Part getArquivo() {
		return arquivo;
	}

	/*@ 
	@ 	requires arquivo2 != null;
	@*/
	public void setArquivo(Part arquivo2) {
		this.arquivo = arquivo2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContestacao() {
		return contestacao;
	}

	/*@ 
	@ 	requires contestacao != null;
	@*/
	public void setContestacao(String contestacao2) {
		this.contestacao = contestacao2;
	}

	public DocumentoRepositorio getDocumentoRepositorio() {
		return documentoRepositorio;
	}

	public void setDocumentoRepositorio(DocumentoRepositorio documentoRepositorio) {
		this.documentoRepositorio = documentoRepositorio;
	}
}
