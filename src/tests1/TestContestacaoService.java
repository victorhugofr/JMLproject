package tests1;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.ContestacaoService;
import br.com.sigcar.repositorios.ContestacaoRepositorio;

public class TestContestacaoService {

	public static void main(String[] args) throws NegocioException {
		
		/*
		//Testando o construtor
		//Contestacao contestacao = null;
		//ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		ContestacaoRepositorio contestacaoRepositorio = null;
		ContestacaoService contestacaoService = new ContestacaoService(contestacaoRepositorio);
		*/
		
		//Testando Adicionar
		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		ContestacaoService contestacaoService = new ContestacaoService(contestacaoRepositorio);
		//Contestacao contestacao = new Contestacao();
		//contestacao.setId(1);
		//contestacao.setTexto("Texto");
		Contestacao contestacao = null;
		contestacaoService.adicionar(contestacao);
		//contestacaoService.adicionar(contestacao);
		
		
		
		
		System.out.println("--Fim da Execução--");
	}

}
