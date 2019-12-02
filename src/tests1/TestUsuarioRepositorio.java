package tests1;


import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.repositorios.UsuarioRepositorio;

public class TestUsuarioRepositorio {

	public static void main(String[] args) {
		/*
		//Testando Salvar
		UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
		Usuario usuario = new Usuario();
		usuario.setId(5);
		usuarioRepositorio.salvar(usuario);
		usuarioRepositorio.salvar(usuario);
		*/
		
		/*
		//Testando contains
		UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
		Usuario usuario = new Usuario();
		usuario.setId(5);
		//usuarioRepositorio.salvar(usuario);
		usuarioRepositorio.contains(null);
		*/
		
		//Testando remover
		UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
		Usuario usuario = new Usuario();
		usuario.setId(5);
		//usuarioRepositorio.salvar(usuario);
		usuarioRepositorio.remover(usuario);
		
		System.out.println("--Fim da Execução--");
	}

}
