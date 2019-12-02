package br.com.sigcar.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Usuario;

public class UsuarioRepositorio {
	private /*@ spec_public @*/  List<Usuario> usuarios;

	
	public UsuarioRepositorio() {
		usuarios = new ArrayList<Usuario>();
	}
	
	/*@ public normal_behavior
	  @ requires usuario!=null;
	  @ ensures \result == (\exists int i; i<=0 && i<usuarios.size();usuarios[i].equals(usuario)); 
	 */
	public /*@ pure @*/ boolean contains(Usuario usuario) {
		for (Usuario u : usuarios) {
			if (u.equals(usuario)) {
				return true;
			}
		}
		return false;
	}
	
	public /*@ pure */ Usuario getUsuario(String login) {
		for (Usuario u : usuarios) {
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
	  @ ensures (\forall Usuario i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures usuarios.size() == \old(usuarios.size())+1;
	  */
	public boolean salvar(Usuario entidade) {
		if(entidade == null || this.contains(entidade)) {
			return false;
		}
		usuarios.add(entidade);
		return true;
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarios;
	}

	/*@ public normal_behavior
	  @ requires entidade!=null && this.contains(entidade);
	  @ ensures \result ==true;
	  @ ensures !contains(entidade);
	  @ ensures (\forall Usuario i; i!=entidade ;contains(i)<==>\old(contains(i)));
	  @ ensures usuarios.size() == \old(usuarios.size())-1;
	  */
	public boolean remover(Usuario entidade) {
		if(entidade==null||!this.contains(entidade)) {
			return false;
		}
		usuarios.remove(entidade);
		return true;
	}
}
