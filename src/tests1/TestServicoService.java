package tests1;

import br.com.sigcar.negocio.ServicoService;
import br.com.sigcar.repositorios.DocumentoRepositorio;
import br.com.sigcar.repositorios.ServicoRepositorio;

public class TestServicoService {

	public static void main(String[] args) {
		
		//Testando construtor
		//DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
		//ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
		DocumentoRepositorio documentoRepositorio = null;
		ServicoRepositorio servicoRepositorio = null;
		ServicoService servicoService =  new ServicoService(documentoRepositorio, servicoRepositorio);

		
		
		
		System.out.println("--Fim da Execução--");
	}

}
