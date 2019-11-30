package tests1;

import br.com.sigcar.dominio.Usuario;
public class TestUsuario {

	public static void main(String[] args) {
		String login = "teste";
		String senha = "teste";
		//String login = null;
		//String senha = null;
		Usuario usuario = new Usuario(login, senha);
		usuario.getLogin();
		usuario.getSenha();
	}

}
