package tests1;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.dominio.Correcao;

public class TestContestacao {

	public static void main(String[] args) {

		//Testando setId()
		int id = 0;
		Contestacao contestacao= new Contestacao();
		contestacao.setId(id);

		/*
		//Testando setTexto()
		Contestacao contestacao = new Contestacao();
		String texto = "";
		contestacao.setTexto(texto);
		*/
		
		System.out.println("--Fim da Execução--");
	}

}
