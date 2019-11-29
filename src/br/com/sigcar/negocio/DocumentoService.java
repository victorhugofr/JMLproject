package br.com.sigcar.negocio;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.repositorios.DocumentoRepositorio;

@Stateless
public class DocumentoService {
	
	@Inject
	private /*@ spec_public @*/ DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();//new pois o JML não inicia o inject
	
	public DocumentoService() {
		
	}
	
	/*@ 
	  @ requires documentoRepositorio2 != null;
	  @*/
	public DocumentoService(DocumentoRepositorio documentoRepositorio2) {
		this.documentoRepositorio=documentoRepositorio2;
	}
	
	/*@  public normal_behavior
	  @   requires documento != null;
	  @   requires documentoRepositorio!=null;
	  @   ensures \result == documento;
	  @ also
	  @  public exceptional_behavior
	  @   requires documentoRepositorio.contains(documento);
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Documento adicionar(Documento documento) throws NegocioException{
		if(!documentoRepositorio.salvar(documento)) {
			throw new NegocioException("Documento nao pode ser nulo ou repetido");
		}
		return documento;
	}
	
	/*@ 
	  @ requires documento != null;
	  @*/
	public Documento buscar(Documento documento) {
		Documento documentoBd = documentoRepositorio.getDocumento(documento.getNome());
		return documentoBd;
	}
}
