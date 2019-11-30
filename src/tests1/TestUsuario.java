package tests1;

import java.util.Date;

import br.com.sigcar.dominio.Usuario;
public class TestUsuario {

	public static void main(String[] args) {
		//String login = "teste";
		//String senha = "teste";
		String login = "";
		//String senha = null;
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		System.out.println(usuario.getLogin());
		usuario.getSenha();
		Date data = null;
		usuario.setDataCadastro(data);
	}

}
