package tests1;

import java.util.Date;

import br.com.sigcar.dominio.Funcionario;

public class TestFuncionario {

	public static void main(String[] args) {
		/*
		//Testando Construtor
		String login = null;
		String senha = null;
		Funcionario funcionario = new Funcionario(login, senha);
		*/
		/*
		//Testando setDataAdmissao(Date)
		//Date data = null;
		String login = "login";
		String senha = "senha";
		//Date data = new Date(System.currentTimeMillis());
		Date data = null;
		Funcionario funcionario = new Funcionario(login, senha);
		funcionario.setDataAdmissao(data);
		*/
		
		//Testenso setfuncao()
		String login = "login";
		String senha = "senha";
		Funcionario funcionario = new Funcionario(login, senha);
		String funcao = null;
		//String funcao = "Funcao";
		funcionario.setFuncao(funcao);
		
		System.out.println("--Fim da Execução--");
	}

}
