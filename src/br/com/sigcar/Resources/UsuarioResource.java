package br.com.sigcar.Resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.negocio.UsuarioService;

@Stateless
@Path("/consulta")
public class UsuarioResource {
	
	@EJB
	private UsuarioService service;
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/usuarios")
	public List<Usuario> listagem() {
		return service.listar();
	}
}
