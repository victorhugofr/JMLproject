package br.com.sigcar.negocio;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.repositorios.ContestacaoRepositorio;

@Stateless
public class ContestacaoService {

	@Inject
	private /*@ spec_public @*/ ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
	
	public ContestacaoService() {
		
	}
	/*@ 
	  @ requires contestacaoRepositorio2 != null;
	  @ assignable this.contestacaoRepositorio;
	  @ ensures this.contestacaoRepositorio == contestacaoRepositorio2;
	  @*/
	public ContestacaoService(ContestacaoRepositorio contestacaoRepositorio2) {
		this.contestacaoRepositorio = contestacaoRepositorio2;
	}
	
	/*@  public normal_behavior
	  @   requires contestacao != null;
	  @   requires contestacaoRepositorio!=null;
	  @   ensures \result == contestacao;
	  @ also
	  @  public exceptional_behavior
	  @   requires contestacaoRepositorio.contains(contestacao);
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Contestacao adicionar(Contestacao contestacao) throws NegocioException {
		if(!contestacaoRepositorio.salvar(contestacao)) {
			throw new NegocioException("Contestacao nao pode ser nula ou repetida");
		}
		return contestacao;
	}
}
