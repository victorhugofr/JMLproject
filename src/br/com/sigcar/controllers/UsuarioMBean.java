package br.com.sigcar.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.repositorios.UsuarioRepositorio;

@Named("usuarioMBean")
@SessionScoped
public class UsuarioMBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UsuarioRepositorio usuarioRepositorio;
	
	private Usuario usuario;
	private Usuario usuarioLogado;
	private DataModel<Usuario> usuariosModel;
	private List<Usuario> usuariosList;
	
	public List<Usuario> getUsuariosList() {
		usuariosList = new ArrayList<Usuario>(usuarioRepositorio.listarUsuarios());
		return usuariosList;
	}

	public void setUsuariosList(List<Usuario> usuariosList) {
		this.usuariosList = usuariosList;
	}

	public DataModel<Usuario> getUsuariosModel() {
		return usuariosModel;
	}

	public void setUsuariosModel(DataModel<Usuario> usuariosModel) {
		this.usuariosModel = usuariosModel;
	}

	public String logar() {
			Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
			if (usuarioBd != null && usuarioBd.getSenha().equals(usuario.getSenha())) {
				usuarioLogado = usuarioBd;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuarioLogado);
				return "/pages/index.jsf?faces-redirect=true";
			}else {
				FacesMessage msg = new FacesMessage("Usuario nao encontrado ou senha incorreta","");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "/login/cadastrar.jsf";
			}
	}

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();

		if (usuarioLogado != null) {
			usuarioLogado = null;
			usuario = null;
		}
		try {
			context.getExternalContext().redirect("/sistemacartorial/login/login.jsf?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/sistemacartorial/login/login.jsf?faces-redirect=true";

	}

	public String listarUsuarios() {
		usuariosModel = new ListDataModel<Usuario>(usuarioRepositorio.listarUsuarios());

		return "/pages/usuarios/list.jsf?faces-redirect=true";
	}
	
	public String removerUsuario() {
		Usuario usuarioRemovido = usuariosModel.getRowData();
		usuarioRepositorio.remover(usuarioRemovido);
		//return listarMateriais();
		usuariosModel = new ListDataModel<Usuario>(usuarioRepositorio.listarUsuarios());
		return "/pages/usuarios/list.jsf";
	}

	public String cadastrar() {
		Date dataCadastro = new Date();
		usuario.setDataCadastro(dataCadastro);
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		if(usuarioBd == null) {
			usuarioRepositorio.salvar(usuario);
			FacesMessage msg = new FacesMessage("Cadastro realizado com sucesso.","");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			usuario = new Usuario();
		}else {
			FacesMessage msg = new FacesMessage("O usuário ja existe.","");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return "/login/login.jsf";
	}

	public String cadastrarLogado() {
		Date dataCadastro = new Date();
		usuario.setDataCadastro(dataCadastro);
		Usuario usuarioBd = usuarioRepositorio.getUsuario(usuario.getLogin());
		if(usuarioBd == null) {
			usuarioRepositorio.salvar(usuario);
			FacesMessage msg = new FacesMessage("Cadastro realizado com sucesso.","");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			usuario = new Usuario();
		}else {
			FacesMessage msg = new FacesMessage("O usuário ja existe.","");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		usuario = new Usuario();
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuario);
		return "/pages/index.jsf";
	}
	
	public String AtualizarDadosUsuario() {
		usuarioRepositorio.salvar(usuarioLogado);
		FacesMessage msg = new FacesMessage("Dados do usuario atualizados","");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "/pages/index.jsf/faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Usuario> getUsuarioList() {
		usuariosList = new ArrayList<Usuario>(usuarioRepositorio.listarUsuarios());
		return usuariosList;
	}
	
	public UsuarioMBean() {
		usuario = new Usuario();
	}
}
