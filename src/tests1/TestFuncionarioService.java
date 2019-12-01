package tests1;

import br.com.sigcar.dominio.Funcionario;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.FuncionarioService;
import br.com.sigcar.repositorios.FuncionarioRepositorio;

public class TestFuncionarioService {

	public static void main(String[] args) throws NegocioException {
		/*
		//Testando Construtor
		//FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		FuncionarioRepositorio funcionarioRepositorio = null;
		FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepositorio);
		*/
		
		/*
		//Testando adicionar
		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepositorio);
		Funcionario funcionario = null;
		//Funcionario funcionario = new Funcionario();
		//funcionario.setId(5);
		//funcionario.setNome("NOMe");
		funcionarioService.adicionar(funcionario);
		//funcionarioService.adicionar(funcionario);
		*/
		
		/*
		//Testando remover
		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepositorio);
		Funcionario funcionarioN = null;
		Funcionario funcionario = new Funcionario();
		funcionario.setId(5);
		funcionario.setNome("NOMe");
		funcionarioService.adicionar(funcionario);
		funcionarioService.remover(funcionario);
		funcionarioService.remover(funcionario);
		*/
		
		//Testando Logar
		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepositorio);
		Funcionario funcionario = new Funcionario();
		funcionario.setId(5);
		funcionario.setNome("NOMe");
		funcionario.setLogin("Login");
		funcionario.setSenha("Senha");
		Funcionario funcionario2 = null;
		funcionarioService.adicionar(funcionario);
		funcionarioService.logar(funcionario2);
		
		
		System.out.println("--Fim da Execução--");
	}

}
