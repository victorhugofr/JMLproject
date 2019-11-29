package br.com.sigcar.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Funcionario;

public class FuncionarioRepositorio {
	private /*@ spec_public @*/  List<Funcionario> funcionarios;

	
	public FuncionarioRepositorio() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	/*@ public normal_behavior
	  @ requires funcionario!=null;
	  @ ensures \result == (\exists int i; i<=0 && i<funcionarios.size();funcionarios[i].equals(funcionario)); 
	 */
	public /*@ pure @*/ boolean contains(Funcionario funcionario) {
		for (Funcionario u : funcionarios) {
			if (u.equals(funcionario)) {
				return true;
			}
		}
		return false;
	}
	
	public /*@ pure @*/ Funcionario getFuncionario(String login) {
		for (Funcionario u : funcionarios) {
			if (u.getLogin().equals(login)) {
				return u;
			}
		}
		return null;
	}

	/*@ public normal_behavior
	  @ requires  entidade!=null && !this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures contains(entidade);
	  @ ensures (\forall Funcionario i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures funcionarios.size() == \old(funcionarios.size())+1;
	  */
	public boolean salvar(Funcionario entidade) {
		if(entidade == null || this.contains(entidade)) {
			return false;
		}
		funcionarios.add(entidade);
		return true;
	}
	
	public List<Funcionario> listarFuncionarios(){
		return funcionarios;
	}

	/*@ public normal_behavior
	  @ requires entidade!=null && this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures !contains(entidade);
	  @ ensures (\forall Funcionario i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures funcionarios.size() == \old(funcionarios.size())-1;
	  */
	public boolean remover(Funcionario entidade) {
		if(entidade == null || !this.contains(entidade)) 
			return false;
		funcionarios.remove(entidade);
		return true;
	}
}
