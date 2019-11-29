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
	private ServicoRepositorio servicoRepositorio = new ServicoRepositorio();//new pois o JML não inicia o inject
	
	@Inject
	private DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
	
	public ServicoService() {
		
	}
	
	public ServicoService(DocumentoRepositorio documentoRepositorio, ServicoRepositorio servicoRepositorio) {
		this.documentoRepositorio=documentoRepositorio;
		this.servicoRepositorio=servicoRepositorio;
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
			NegocioException("Servico j est aberto");
		}
		return servico;
	}
	
	public Servico buscar(Servico servico) {
		Servico servicoBd = servicoRepositorio.getServico(servico.getNomeEntidade());
		return servicoBd;
	}
	
	public List<Servico> listar() {
		return servicoRepositorio.listarServicos();
	}
	
}	
