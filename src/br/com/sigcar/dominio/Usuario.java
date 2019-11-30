package br.com.sigcar.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private /*@ spec_public @*/ int id;
	
	@Temporal(TemporalType.DATE)
	private /*@ spec_public @*/ Date dataCadastro;
	
	private /*@ spec_public @*/ String login;
	private /*@ spec_public @*/ String cpf;
	private /*@ spec_public @*/ String email;
	private /*@ spec_public @*/ String telefone;
	private /*@ spec_public @*/ String senha;
	private /*@ spec_public @*/ String nome;
	private /*@ spec_public @*/ String passaporte;

	public Usuario() {
	}
	/*@ requires login != "" && senha != null;
	 @ assignable this.login, this.senha;
	 @ ensures this.login == login && this.senha == senha;
	 */
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	/*@ requires dataCadastro != null;
	@ assignable this.dataCadastro;
	@ ensures this.dataCadastro == dataCadastro;
	*/
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public /*@ pure @*/ int  getId() {
		return id;
	}
	
	//@ requires id > 0;
	//@ assignable this.id;
	//@ ensures this.id == id;
	public void setId(int id) {
		this.id = id;
	}
	
	public /*@ pure @*/ String getLogin() {
		return login;
	}
	
	//@ requires login != "";
	//@ assignable this.login;
	//@ ensures this.login == login;
	public void setLogin(String login) {
		this.login = login;
	}

	public /*@ pure @*/ String getSenha() {
		return senha;
	}
	
	//@ requires senha != null;
	//@ assignable this.senha;
	//@ ensures this.senha == senha;
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	//@ requires nome != null;
	//@ assignable this.nome;
	//@ ensures this.nome == nome;
	public void setNome(String nome) {
		nome=nome.toUpperCase();
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	//@ requires cpf != null;
	//@ assignable this.cpf, this.login;
	//@ ensures this.cpf == cpf && this.login == cpf;
	public void setCpf(String cpf) {
		this.cpf = cpf;
		this.login = cpf;
	}

	public String getEmail() {
		return email;
	}
	//@ requires email != null;
	//@ assignable this.email;
	//@ ensures this.email == email;
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}
	//@ requires telefone != null;
	//@ assignable this.telefone;
	//@ ensures this.telefone == telefone;
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassaporte() {
		return passaporte;
	}
	//@ requires passaporte != null;
	//@ assignable this.passaporte;
	//@ ensures this.passaporte == passaporte;
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((passaporte == null) ? 0 : passaporte.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	/**/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (passaporte == null) {
			if (other.passaporte != null)
				return false;
		} else if (!passaporte.equals(other.passaporte))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}
