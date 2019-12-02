package tests1;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.repositorios.DocumentoRepositorio;

public class TestDocumentoRepositorio {

	public static void main(String[] args) {
		/*
		//Testando Salvar
		DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
		//Documento documento = new Documento();
		//documento.setId(5);
		Documento documento = null;
		documentoRepositorio.salvar(documento);
		*/
		
		/*
		//Testando contains
		DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
		Documento documento = new Documento();
		documento.setId(5);
		//documentoRepositorio.salvar(documento);
		documentoRepositorio.contains(documento);
		*/
		
		//Testando remover
		DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
		Documento documento = new Documento();
		documento.setId(5);
		documentoRepositorio.salvar(documento);
		documentoRepositorio.remover(documento);
		
		System.out.println("--Fim da Execução--");
	}

}
