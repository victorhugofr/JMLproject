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
	  @*/
	public ServicoService(DocumentoRepositorio documentoRepositorio2, ServicoRepositorio servicoRepositorio2) {
		this.documentoRepositorio=documentoRepositorio2;
		this.servicoRepositorio=servicoRepositorio2;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Servico adicionar(Servico servico, List<Documento> documentos)  throws NegocioException {			
		Servico servicoBd = servicoRepositorio.getServico(servico.getNomeEntidade());
		if(servicoBd == null) { 
			if(documentos==null) {
				throw new
				NegocioException("Insira um documento");
			}
			for(int i=0;i<documentos.size();i++) {
				documentoRepositorio.salvar(documentos.get(i));
			}			
			servico.setDocumentos(documentos);
			servico.setStatus(true);
			servicoRepositorio.salvar(servico);
			servicoBd=null;
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
