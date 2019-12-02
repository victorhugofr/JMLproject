package tests1;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.ContestacaoService;
import br.com.sigcar.repositorios.ContestacaoRepositorio;

public class TestContestacaoService {

	public static void main(String[] args) throws NegocioException {
		

		ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();

		int id = 1;
		Contestacao contestacao= new Contestacao();
		contestacao.setId(id);

		ContestacaoService contestacaoService =  new ContestacaoService(contestacaoRepositorio);
//		//fluxo feliz
//		contestacaoService.adicionar(contestacao);
		
		//fluxo exceptional
		contestacaoService.adicionar(contestacao);
		contestacaoService.adicionar(contestacao);
		/*
		//Testando o construtor
		//Contestacao contestacao = null;
		//ContestacaoRepositorio contestacaoRepositorio = new ContestacaoRepositorio();
		ContestacaoRepositorio contestacaoRepositorio = null;
		ContestacaoService contestacaoService = new ContestacaoService(contestacaoRepositorio);
		*/
		
		//Testando Adicionar
		//Contestacao contestacao = new Contestacao();
		//contestacao.setId(1);
		//contestacao.setTexto("Texto");
		Contestacao contestacao2 = null;
		contestacaoService.adicionar(contestacao2);
		//contestacaoService.adicionar(contestacao);
		

		
		
		System.out.println("--Fim da Execução--");
	}
}
