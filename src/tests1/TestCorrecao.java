package tests1;

import br.com.sigcar.dominio.Correcao;

public class TestCorrecao {

	public static void main(String[] args) {
		/*
		//Testando setId()
		int id = 0;
		Correcao correcao = new Correcao();
		correcao.setId(id);
		*/
		
		//Testando setTexto()
		Correcao correcao = new Correcao();
		String texto = "";
		correcao.setTexto(texto);
		System.out.println("--Fim da Execução--");
	}

}
