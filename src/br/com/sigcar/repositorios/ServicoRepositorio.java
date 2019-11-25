package br.com.sigcar.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Servico;

public class ServicoRepositorio {

	public static List<Servico> servicos;
	
	public ServicoRepositorio() {
		servicos = new ArrayList<Servico>();
	}
	
	/*@ public normal_behavior
	  @ requires servico!=null;
	  @ ensures \result == (\exists int i; i<=0 && i<servicos.size();servicos[i].equals(servico)); 
	 */
	public /*@ pure @*/ boolean contains(Servico servico) {
		for (Servico u : servicos) {
			if (u.equals(servico)) {
				return true;
			}
		}
		return false;
	}
	
	public  Servico getServico(String nomeEntidade) {
		for (Servico u : servicos) {
			if (u.getNomeEntidade().equals(nomeEntidade)) {
				return u;
			}
		}
		return null;
	}
	
	/*@ public normal_behavior
	  @ requires  entidade!=null && !this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures contains(entidade);
	  @ ensures (\forall Servico i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures servicos.size() == \old(servicos.size())+1;
	  */
	public boolean salvar(Servico entidade) {
		servicos.add(entidade);
		return true;
	}
	
	public List<Servico> listarServicos(){
		return servicos;
	}
	

	/*@ public normal_behavior
	  @ requires entidade!=null && this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures !contains(entidade);
	  @ ensures (\forall Servico i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures servicos.size() == \old(servicos.size())-1;
	  */
	public boolean remover(Servico entidade) {
		servicos.remove(entidade);
		return true;
	}
}
