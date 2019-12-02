package tests1;

import java.util.ArrayList;
import java.util.List;

import br.com.sigcar.dominio.Documento;
import br.com.sigcar.dominio.Servico;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.DocumentoService;
import br.com.sigcar.negocio.ServicoService;
import br.com.sigcar.repositorios.DocumentoRepositorio;
import br.com.sigcar.repositorios.ServicoRepositorio;

public class TestServicoService {

	public static void main(String[] args) throws NegocioException {
		
		ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
		DocumentoRepositorio documentoRepositorio = new DocumentoRepositorio();
		
		List<Documento> documentos = new ArrayList<Documento>();
		
		Documento documento = new Documento();
		documento.setId(1);
		
		documentos.add(documento);
		
		int id = 1;
		Servico servico= new Servico();
		servico.setId(id);

		ServicoService servicoService =  new ServicoService(documentoRepositorio,servicoRepositorio);
//		//fluxo feliz
//		servicoService.adicionar(servico,documentos);
		
		//fluxo exceptional
//		servicoService.adicionar(servico,documentos);
//		servicoService.adicionar(servico,documentos);
		
		
		System.out.println("--Fim da Execução--");
	}
}
