package br.com.sigcar.negocio;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.repositorios.DocumentoRepositorio;

@Stateless
public class DocumentoService {
	
	@Inject
	private DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();//new pois o JML não inicia o inject
	
	public DocumentoService() {
		
	}
	public DocumentoService(DocumentoRepositorio documentoRepositorio) {
		this.documentoRepositorio=documentoRepositorio;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Documento adicionar(Documento documento) {
		documentoRepositorio.salvar(documento);
		return documento;
	}
	
	public Documento Buscar(Documento documento) {
		Documento documentoBd = documentoRepositorio.getDocumento(documento.getNome());
		return documentoBd;
	}
}
