package tests1;

import br.com.sigcar.dominio.Servico;
import br.com.sigcar.repositorios.ServicoRepositorio;

public class TestServicoRepositorio {

	public static void main(String[] args) {
		
		/*
		//Testando Salvar
		ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
		//Servico servico = new Servico();
		//servico.setId(5);
		Servico servico = null;
		servicoRepositorio.salvar(servico);
		servicoRepositorio.salvar(servico);
		*/
		
		/*
		//Testando contains
		ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
		//Servico servico = new Servico();
		//servico.setId(5);
		Servico servico = null;
		servicoRepositorio.contains(servico);
		*/
		
		//Testando Remover
		ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
		Servico servico = new Servico();
		servico.setId(5);
		//Servico servico = null;
		servicoRepositorio.remover(servico);
		
		
		
		System.out.println("--Fim da Execução--");
	}

}
