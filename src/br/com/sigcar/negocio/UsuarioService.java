package br.com.sigcar.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.repositorios.UsuarioRepositorio;

@Stateless
public class UsuarioService {
	
	@Inject
	private /*@ spec_public @*/ UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();//new pois o JML não inicia o inject
	
	public UsuarioService() {
		
	}
	/*@ 
	  @ requires usuarioRepositorio2 != null;
	  @*/
	public UsuarioService(UsuarioRepositorio usuarioRepositorio2) {
		this.usuarioRepositorio = usuarioRepositorio2;
	}
	
	/*@  public normal_behavior
	  @   requires usuario != null;
	  @   requires usuarioRepositorio!=null;
	  @   ensures \result == usuario;
	  @ also
	  @  public exceptional_behavior
	  @   requires usuarioRepositorio.contains(usuario);
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public	Usuario adicionar(Usuario usuario) throws NegocioException {
		if(usuarioRepositorio.salvar(usuario)) {
			return usuario;
		}
		else {
			throw new
			NegocioException("O usuario ja existe.");
		}	
	}
	
	/*@  public normal_behavior
	  @   requires usuario != null;
	  @   requires usuarioRepositorio!=null;
	  @ also
	  @  public exceptional_behavior
	  @   requires !usuarioRepositorio.contains(usuario);
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Usuario usuario) throws NegocioException {
		if(!usuarioRepositorio.remover(usuario)) {
			throw new NegocioException("Usuario nao existe ou nulo");
		}
	}
	
	/*@ 
	  @ requires usuarioRepositorio != null;
	  @*/
	public List<Usuario> listar() {
		return usuarioRepositorio.listarUsuarios();
	}
	
	/*@ 
	  @ requires usuario != null;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizar(Usuario usuario) {
		usuarioRepositorio.salvar(usuario);
	}
	
	/*@ 
	  @ requires usuario != null;
	  @ requires usuarioRepositorio !=null;
	  @*/
	public Usuario buscar(Usuario usuario) {
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		return usuarioBd;
	}
	
	/*@  public normal_behavior
	  @   requires usuario != null;
	  @   requires usuarioRepositorio!=null;
	  @	  requires usuarioRepositorio.getUsuario(usuario.getLogin()).getSenha().equals(usuario.getSenha());
	  @   ensures \result == usuario;
	  @ also
	  @  public exceptional_behavior
	  @   requires usuario != null;
	  @   requires usuarioRepositorio!=null;
	  @   requires !usuarioRepositorio.getUsuario(usuario.getLogin()).getSenha().equals(usuario.getSenha());
	  @   signals_only NegocioException;
	  @   signals (NegocioException e)
	  @               e.getMessage().equals("Senha incorreta");
	  @ also
	  @  public exceptional_behavior
	  @   requires usuario != null;
	  @   requires usuarioRepositorio!=null;
	  @   requires usuarioRepositorio.getUsuario(usuario.getLogin()) == null;
	  @   signals_only NegocioException;
	  @   signals (NegocioException e)
	  @               e.getMessage().equals("Usuario nao encontrado");
	  @ also
	  @  public exceptional_behavior
	  @   requires usuario == null;
	  @   signals_only NegocioException;
	  @   signals (NegocioException e )
	  @                e.getMessage().equals("Usuario nao encontrado");
	  @*/
	public Usuario logar(Usuario usuario) throws NegocioException{
		if(usuario==null) {
			throw new NegocioException("Usuario nao encontrado");
		}
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		if (usuarioBd != null && usuarioBd.getSenha().equals(usuario.getSenha())) {
			return usuarioBd;
		} else if(usuarioBd != null && !usuarioBd.getSenha().equals(usuario.getSenha())) {
			throw new
			NegocioException("Senha incorreta");
		} else {
			throw new
			NegocioException("usurio no encontrado");
		}
	}
}
