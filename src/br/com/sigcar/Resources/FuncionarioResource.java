package br.com.sigcar.Resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.sigcar.dominio.Funcionario;
import br.com.sigcar.negocio.FuncionarioService;

@Stateless
@Path("/consulta")
public class FuncionarioResource {
	
	@EJB
	private FuncionarioService service;
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/funcionarios")
	public List<Funcionario> listagem() {
		return service.listar();
	}
}
