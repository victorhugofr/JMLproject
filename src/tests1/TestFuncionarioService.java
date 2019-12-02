package tests1;

import br.com.sigcar.dominio.Funcionario;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.FuncionarioService;
import br.com.sigcar.repositorios.FuncionarioRepositorio;

public class TestFuncionarioService {
	public static void main(String[] args) throws NegocioException {
			
			FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
	
			int id = 1;
			Funcionario funcionario= new Funcionario();
			funcionario.setId(id);
			funcionario.setLogin("login");
			funcionario.setSenha("senha");
	
			FuncionarioService funcionarioService =  new FuncionarioService(funcionarioRepositorio);
	//		//fluxo feliz
	//		funcionarioService.adicionar(funcionario);
			
			//fluxo exceptional adicionar
//			funcionarioService.adicionar(funcionario);
//			funcionarioService.adicionar(funcionario);
			
			//fluxo exceptional remover
//			funcionarioService.remover(funcionario);
			
			//fluxo feliz logar
//			funcionarioService.adicionar(funcionario);
//			funcionarioService.logar(funcionario);
			
			//fluxo exceptional logar
			funcionarioService.adicionar(funcionario);
			funcionario.setSenha("outra senha");
			funcionarioService.logar(null);
			
			
			System.out.println("--Fim da Execução--");
		}
}
