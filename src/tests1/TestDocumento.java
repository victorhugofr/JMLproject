package tests1;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.dominio.Endereco;
import br.com.sigcar.enums.StatusDocumento;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.dominio.Correcao;
public class TestDocumento {

	public static void main(String[] args) {
		
		/*
		//Testando setArquivoBase64()
		//String arquivo = "arquivo";
		String arquivo = null;
		Documento documento = new Documento();
		documento.setArquivoBase64(arquivo);
		*/
		
		/*
		//Testando setExtensao()
		//String extensao = "Extensao";
		String extensao = null;
		Documento documento = new Documento();
		documento.setExtensao(extensao);
		*/
	
		/*
		//Testando setNome()
		//String nome = "Nome";
		String nome = null;
		Documento documento = new Documento();
		documento.setNome(nome);
		*/
		
		/*
		//Testando setId()
		//int id= "5";
		//int id = 0;
		int id = -1;
		Documento documento = new Documento();
		documento.setId(id);
		*/
		
		/*
		//Testando setStatus()
		//StatusDocumento statusDoc = StatusDocumento.CORRIGIDO;
		StatusDocumento statusDoc = null;
		Documento documento = new Documento();
		documento.setStatus(statusDoc);
		*/
		
		/*
		//Testando setContestacao()
		List<Contestacao> contestacao = new ArrayList<Contestacao>();
		Documento documento = new Documento();
		documento.setContestacao(contestacao);
		*/
		
		/*
		//Testando setCorrecao()
		List<Correcao> correcao = new ArrayList<Correcao>();
		Documento documento = new Documento();
		documento.setCorrecao(correcao);
		*/
		
		//Testando setObservacao()
		//String observacao = "Observacao";
		String observacao = "";
		Documento documento = new Documento();
		documento.setObservacao(observacao);
		System.out.println("--Fim da Execução--");
	}

}
