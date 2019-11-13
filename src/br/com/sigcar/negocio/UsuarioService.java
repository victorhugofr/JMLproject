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
	private UsuarioRepositorio usuarioRepositorio;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public	Usuario adicionar(Usuario usuario) throws NegocioException {
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		if(usuarioBd == null) {
			usuarioRepositorio.salvar(usuario);
		}
		else {
			throw new
			NegocioException("O usuário já existe.");
		}	
		return usuario;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Usuario usuario) {
		usuarioRepositorio.remover(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepositorio.listarUsuarios();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizar(Usuario usuario) {
		usuarioRepositorio.salvar(usuario);
	}
	
	public Usuario buscar(Usuario usuario) {
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		return usuarioBd;
	}
	
	public Usuario logar(Usuario usuario) throws NegocioException{
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		if (usuarioBd != null && usuarioBd.getSenha().equals(usuario.getSenha())) {
			return usuarioBd;
		} else if(usuarioBd != null && !usuarioBd.getSenha().equals(usuario.getSenha())) {
			throw new
			NegocioException("Senha incorreta");
		} else {
			throw new
			NegocioException("usuário não encontrado");
		}
	}
}
