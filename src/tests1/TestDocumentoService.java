package tests1;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.DocumentoService;
import br.com.sigcar.repositorios.DocumentoRepositorio;

public class TestDocumentoService {


public static void main(String[] args) throws NegocioException {
		
		DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();

		int id = 1;
		Documento documento= new Documento();
		documento.setId(id);

		DocumentoService documentoService =  new DocumentoService(documentoRepositorio);
//		//fluxo feliz
//		documentoService.adicionar(documento);
		
		//fluxo exceptional
		documentoService.adicionar(documento);
		documentoService.adicionar(documento);
		
		System.out.println("--Fim da Execução--");
	}

}
