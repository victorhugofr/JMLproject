package tests1;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.repositorios.ContestacaoRepositorio;

public class TestContestacaoRepositorio {

	public static void main(String[] args) {
		/*
		//Testando o Contains()
		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		Contestacao contestacao = null;
		contestacaoRepositorio.contains(contestacao);
		*/
		/*
		//Testando salvar
		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		//Contestacao contestacao = new Contestacao();
		//contestacao.setId(5);
		Contestacao contestacao = null;
		contestacaoRepositorio.salvar(contestacao);
		*/
		
		//Testando Remover
		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		//Contestacao contestacao = new Contestacao();
		Contestacao contestacao = null;
		//contestacao.setId(5);
		//contestacaoRepositorio.salvar(contestacao);
		contestacaoRepositorio.remover(contestacao);
		System.out.println("--Fim da Execução--");
	}

}
