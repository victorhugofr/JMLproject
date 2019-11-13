package br.com.sigcar.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.sigcar.dominio.Funcionario;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.repositorios.FuncionarioRepositorio;

@Stateless
public class FuncionarioService {
	
	@Inject
	private FuncionarioRepositorio funcionarioRepositorio;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public	Funcionario adicionar(Funcionario funcionario) throws NegocioException {
		Funcionario funcionarioBd = funcionarioRepositorio.getFuncionario(funcionario.getLogin());
		if(funcionarioBd == null) {
			funcionarioRepositorio.salvar(funcionario);
		}
		else {
			throw new
			NegocioException("O funcion�rio j� existe.");
		}	
		return funcionario;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Funcionario funcionario) {
		funcionarioRepositorio.remover(funcionario);
	}
	
	public List<Funcionario> listar() {
		return funcionarioRepositorio.listarUsuarios();
	}
	
	public Funcionario buscar(Funcionario funcionario) {
		Funcionario funcionarioBd = funcionarioRepositorio.getFuncionario(funcionario.getLogin());
		return funcionarioBd;
	}
	
	public Funcionario logar(Funcionario funcionario) throws NegocioException{
		Funcionario funcionarioBd = funcionarioRepositorio.getFuncionario(funcionario.getLogin());
		if (funcionarioBd != null && funcionarioBd.getSenha().equals(funcionario.getSenha())) {
			return funcionarioBd;
		} else if(funcionarioBd != null && !funcionarioBd.getSenha().equals(funcionario.getSenha())) {
			throw new
			NegocioException("Senha incorreta");
		} else {
			throw new
			NegocioException("Funcionario n�o encontrado");
		}
	}
}
	
