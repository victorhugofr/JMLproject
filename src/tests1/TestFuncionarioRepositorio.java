package tests1;

import br.com.sigcar.dominio.Funcionario;
import br.com.sigcar.repositorios.FuncionarioRepositorio;

public class TestFuncionarioRepositorio {

	public static void main(String[] args) {
		/*
		//Testando Salvar
		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		Funcionario funcionario= new Funcionario();
		funcionario.setId(5);
		//Funcionario funcionario = null;
		funcionarioRepositorio.salvar(funcionario);
		funcionarioRepositorio.salvar(funcionario);
		*/
		
		/*
		//Testando Contains
		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		Funcionario funcionario= new Funcionario();
		funcionario.setId(5);
		funcionarioRepositorio.salvar(funcionario);
		funcionarioRepositorio.contains(null);
		*/
		
		//Testando Remover
		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		Funcionario funcionario= new Funcionario();
		funcionario.setId(5);
		//funcionarioRepositorio.salvar(funcionario);
		funcionarioRepositorio.remover(funcionario);
		System.out.println("--Fim da Execução--");

	}

}
