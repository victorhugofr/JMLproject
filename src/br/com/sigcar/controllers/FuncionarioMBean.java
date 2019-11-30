package br.com.sigcar.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sigcar.dominio.Funcionario;
import br.com.sigcar.exceptions.NegocioException;
import br.com.sigcar.negocio.FuncionarioService;

@Named("funcionarioMBean")
@SessionScoped
public class FuncionarioMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private FuncionarioService funcionarioService;
	private Funcionario funcionario;
	private Funcionario funcionarioLogado;
	private DataModel<Funcionario> funcionariosModel;

	public DataModel<Funcionario> getUsuariosModel() {
		return funcionariosModel;
	}

	public void setUsuariosModel(DataModel<Funcionario> funcionariosModel) {
		this.funcionariosModel = funcionariosModel;
	}

	public String logar() {	
		try {
			System.out.println("estou aqui");
			Funcionario funcionarioBd = funcionarioService.logar(funcionario);
			funcionarioLogado = funcionarioBd;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionarioLogado", funcionarioLogado);
			return "/pages/index.jsf?faces-redirect=true";
		} catch (NegocioException e) {
			FacesMessage msg = new FacesMessage(e.getMessage(),"");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();

		if (funcionarioLogado != null) {
			funcionarioLogado = null;
			funcionario = null;
		}
		try {
			context.getExternalContext().redirect("/sistemacartorial/login/login.jsf?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/sistemacartorial/login/login.jsf?faces-redirect=true";

	}

	public String listarFuncionarios() {
		funcionariosModel = new ListDataModel<Funcionario>(funcionarioService.listar());

		return "/pages/funcionarios/list.jsf?faces-redirect=true";
	}
	
	public String removerFuncionario() {
		Funcionario usuarioRemovido = funcionariosModel.getRowData();
		try {
			funcionarioService.remover(usuarioRemovido);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return listarMateriais();
		funcionariosModel = new ListDataModel<Funcionario>(funcionarioService.listar());
		return "/pages/funcionarios/list.jsf";
	}

	public String cadastrar() {
		Date dataCadastro = new Date();
		funcionario.setDataCadastro(dataCadastro);
		try {
			funcionarioService.adicionar(funcionario);
		} catch (NegocioException e) {
			FacesMessage msg = new FacesMessage(e.getMessage(),"");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "/pages/funcionarios/novo.jsf";

		}
		FacesMessage msg = new FacesMessage("Cadastro realizado com sucesso.","");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		funcionario=new Funcionario();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionarioLogado", funcionario);
		return "/pages/index.jsf";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario usuario) {
		this.funcionario = usuario;
	}

	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public FuncionarioMBean() {
		funcionario = new Funcionario();
	}
}
