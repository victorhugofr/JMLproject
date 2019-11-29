package br.com.sigcar.negocio;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.repositorios.ContestacaoRepositorio;

@Stateless
public class ContestacaoService {

	@Inject
	ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
	
	public ContestacaoService() {
		
	}
	public ContestacaoService(ContestacaoRepositorio contestacaoRepositorio) {
		this.contestacaoRepositorio = contestacaoRepositorio;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Contestacao adicionar(Contestacao contestacao) {
		contestacaoRepositorio.salvar(contestacao);
		return contestacao;
	}
}
