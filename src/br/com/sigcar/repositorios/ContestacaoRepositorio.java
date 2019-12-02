package br.com.sigcar.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.exceptions.NegocioException;
public class ContestacaoRepositorio {

	private /*@ spec_public @*/ List<Contestacao> contestacoes;
	
	
	public ContestacaoRepositorio() {
		contestacoes = new ArrayList<Contestacao>();
	}
	/*@ public normal_behavior
	  @ requires contestacao!=null;
	  @ ensures \result == (\exists int i; i<=0 && i<contestacoes.size();contestacoes[i].equals(contestacao)); 
	 */
	public /*@ pure @*/ boolean contains(Contestacao contestacao) {
		for (Contestacao u : contestacoes) {
			if (u.equals(contestacao)) {
				return true;
			}
		}
		return false;
		
	}
	
	/*@ public normal_behavior
	  @ requires  entidade!=null && this.contains(entidade);
	  @ ensures \result==true;
	  @ ensures !contains(entidade);
	  @ ensures (\forall Contestacao i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures contestacoes.size() == \old(contestacoes.size())-1;
	  */
	public boolean remover(Contestacao entidade) {
		contestacoes.remove(entidade);
		return true;
	}
	/*@ public normal_behavior
	  @ requires  entidade!=null && !this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures contains(entidade);
	  @ ensures (\forall Contestacao i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures contestacoes.size() == \old(contestacoes.size())+1;
	  */
	public boolean salvar(Contestacao entidade) {
		if(entidade == null || this.contains(entidade)) {
			return false;
		}
		contestacoes.add(entidade);
		return true;
	}
	
	public /*@ pure @*/ List<Contestacao> listarContestacoes(){
		return contestacoes;
	}
}
