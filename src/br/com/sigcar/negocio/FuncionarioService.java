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
	private /*@ spec_public @*/ FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();//new pois o JML não inicia o inject
	
	public FuncionarioService() {
		
	}
	
	/*@ 
	  @ requires funcionarioRepositorio2 != null;
	  @ assignable this.funcionarioRepositorio;
	  @ ensures this.funcionarioRepositorio == funcionarioRepositorio2;
	  @*/
	public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio2) {
		this.funcionarioRepositorio=funcionarioRepositorio2;
	}
	
	/*@  public normal_behavior
	  @   requires funcionario != null;
	  @   requires funcionarioRepositorio!=null;
	  @   ensures \result == funcionario;
	  @ also
	  @  public exceptional_behavior
	  @   requires funcionarioRepositorio.contains(funcionario);
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public	Funcionario adicionar(Funcionario funcionario) throws NegocioException {
		if(funcionarioRepositorio.salvar(funcionario)) {
			return funcionario;
		}
		else {
			throw new
			NegocioException("O funcionario nao pode ser nulo ou ja existe");
		}	
	}
	
	/*@  public normal_behavior
	  @   requires funcionario != null;
	  @   requires funcionarioRepositorio!=null;
	  @ also
	  @  public exceptional_behavior
	  @   requires !funcionarioRepositorio.contains(funcionario);
	  @   signals_only NegocioException;
	  @*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Funcionario funcionario) throws NegocioException {
		if(!funcionarioRepositorio.remover(funcionario)) {
			throw new NegocioException("Funcionario nao existe ou nulo");
		}
	}
	
	/*@ 
	  @ requires funcionarioRepositorio != null;
	  @*/
	public /*@ pure @*/ List<Funcionario> listar() {
		return funcionarioRepositorio.listarFuncionarios();
	}
	
	/*@ 
	  @ requires funcionario != null;
	  @*/
	public Funcionario buscar(Funcionario funcionario) {
		Funcionario funcionarioBd = funcionarioRepositorio.getFuncionario(funcionario.getLogin());
		return funcionarioBd;
	}
	
	/*@  public normal_behavior
	  @   requires funcionario != null;
	  @   requires funcionarioRepositorio!=null;
	  @	  requires funcionarioRepositorio.getFuncionario(funcionario.getLogin()).getSenha().equals(funcionario.getSenha());
	  @   ensures \result == funcionario;
	  @ also
	  @  public exceptional_behavior
	  @   requires funcionario == null;
	  @   signals_only NegocioException;
	  @ also
	  @  public exceptional_behavior
	  @   requires funcionario != null;
	  @   requires funcionarioRepositorio!=null;
	  @   requires !funcionarioRepositorio.getFuncionario(funcionario.getLogin()).getSenha().equals(funcionario.getSenha());
	  @   signals_only NegocioException;
	  @   signals (NegocioException e)
	  @               e.getMessage().equals("Senha incorreta");
	  @ also
	  @  public exceptional_behavior
	  @   requires funcionario != null;
	  @   requires funcionarioRepositorio!=null;
	  @   requires funcionarioRepositorio.getFuncionario(funcionario.getLogin()) == null;
	  @   signals_only NegocioException;
	  @   signals (NegocioException e)
	  @               e.getMessage().equals("Funcionario nao encontrado");
	  @*/
	public Funcionario logar(Funcionario funcionario) throws NegocioException{
		if(funcionario==null) {
			throw new NegocioException("Funcionario nao encontrado");
		}
		Funcionario funcionarioBd = funcionarioRepositorio.getFuncionario(funcionario.getLogin());
		if (funcionarioBd != null && funcionarioBd.getSenha().equals(funcionario.getSenha())) {
			return funcionarioBd;
		} else if(funcionarioBd != null && !funcionarioBd.getSenha().equals(funcionario.getSenha())) {
			throw new
			NegocioException("Senha incorreta");
		} else {
			throw new
			NegocioException("Funcionario nao encontrado");
		}
	}
}
