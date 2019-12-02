package br.com.sigcar.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.dominio.Servico;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.repositorios.DocumentoRepositorio;
import br.com.sigcar.repositorios.ServicoRepositorio;


@Stateless
public class ServicoService {
	
	@Inject
	private /*@ spec_public @*/ ServicoRepositorio servicoRepositorio = new ServicoRepositorio();//new pois o JML não inicia o inject
	
	@Inject
	private /*@ spec_public @*/ DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
	
	public ServicoService() {
		
	}
	/*@ 
	  @ requires documentoRepositorio2 != null;
	  @ requires servicoRepositorio2 != null;
	  @ assignable this.documentoRepositorio, this.servicoRepositorio;
	  @ ensures this.documentoRepositorio == documentoRepositorio2 && this.servicoRepositorio == servicoRepositorio2;
	  @*/
	public ServicoService(DocumentoRepositorio documentoRepositorio2, ServicoRepositorio servicoRepositorio2) {
		this.documentoRepositorio=documentoRepositorio2;
		this.servicoRepositorio=servicoRepositorio2;
	}
	
	/*@  public normal_behavior
	  @   requires servico != null;
	  @   requires servicoRepositorio!=null;
	  @   requires documentoRepositorio!=null;
	  @   requires documentos != null;
	  @   ensures \result == servico;
	  @ also
	  @  public exceptional_behavior
	  @   requires servicoRepositorio.contains(servico);
	  @   signals_only NegocioException;
	  @ also
	  @	 public exceptional_behavior
	  @	  requires documentos==null;
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Servico adicionar(Servico servico, List<Documento> documentos)  throws NegocioException {			
		servico.setDocumentos(documentos);
		servico.setStatus(true);
		if(servicoRepositorio.salvar(servico)) { 
			if(documentos==null) {
				throw new
				NegocioException("Insira um documento");
			}
			for(int i=0;i<documentos.size();i++) {
				documentoRepositorio.salvar(documentos.get(i));
			}			
		}else {
			throw new
			NegocioException("Servico ja esta aberto");
		}
		return servico;
	}
	
	/*@ 
	  @ requires servicoRepositorio != null;
	  @*/
	public Servico buscar(Servico servico) {
		Servico servicoBd = servicoRepositorio.getServico(servico.getNomeEntidade());
		return servicoBd;
	}
	
	/*@ 
	  @ requires servicoRepositorio != null;
	  @*/
	public List<Servico> listar() {
		return servicoRepositorio.listarServicos();
	}
	
}	
