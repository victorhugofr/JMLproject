package tests1;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.DocumentoService;
import br.com.sigcar.repositorios.DocumentoRepositorio;

public class TestDocumentoService {

	public static void main(String[] args) throws NegocioException {
		/*
		//Testando Construtor
		DocumentoRepositorio documentoRepositorio = null;
		DocumentoService documentoService = new DocumentoService(documentoRepositorio);
		*/
		
		//Testando adicionar()
		DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
		DocumentoService documentoService = new DocumentoService(documentoRepositorio);
		Documento documento = null;
		//Documento documento = new Documento();
		//documento.setId(1);
		//documento.setObservacao("Observacao");
		documentoService.adicionar(documento);
		//documentoService.adicionar(documento);
		
		
		
		System.out.println("--Fim da Execução--");
	}

}
