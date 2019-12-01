package br.com.sigcar.dominio;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import br.com.sigcar.enums.StatusDocumento;

@Entity
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private /*@ spec_public @*/ int id;
	
	@Enumerated(EnumType.STRING)
	private /*@ spec_public @*/ StatusDocumento status;
	
	private /*@ spec_public @*/ String observacao;
	
	@OneToMany
	private /*@ spec_public @*/ List<Contestacao> contestacoes;
	
	@OneToMany
	private /*@ spec_public @*/ List<Correcao> correcao;
	
	private /*@ spec_public @*/ String nome;

	@Column(columnDefinition="text")
	private /*@ spec_public @*/ String arquivoBase64;
	
	private /*@ spec_public @*/ String extensao; //pdf,docx
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private /*@ spec_public @*/ byte[] arquivoBase64Original;
	
	
	public /*@ pure @*/ String getArquivoBase64() {
		return arquivoBase64;
	}

	//@ requires arquivoBase64 != null;
	//@ assignable this.arquivoBase64;
	//@ ensures this.arquivoBase64 == arquivoBase64;
	public void setArquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}

	public /*@ pure@*/ String getExtensao() {
		return extensao;
	}

	//@ requires extensao != null;
	//@ assignable this.extensao;
	//@ ensures this.extensao == extensao;
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public byte[] getArquivoBase64Original() {
		return arquivoBase64Original;
	}
	//@ requires arquivoBase64Original != null;
	//@ assignable this.arquivoBase64Original;
	//@ensures this.arquivoBase64Original == arquivoBase64Original;
	public void setArquivoBase64Original(byte[] arquivoBase64Original) {
		this.arquivoBase64Original = arquivoBase64Original;
	}

	public /*@ pure @*/ int getId() {
		return id;
	}

	//@ requires id > 0;
	//@ assignable this.id;
	//@ ensures this.id == id; 
	public void setId(int id) {
		this.id = id;
	}


	public /*@ pure@*/ String getObservacao() {
		return observacao;
	}
	
	//@ requires observacao != "";
	//@ assignable this.observacao;
	//@ ensures this.observacao == observacao;
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public /*@ pure @*/ String getNome() {
		return nome;
	}

	//@ requires nome != null || nome != "";
	//@ assignable this.nome;
	//@ ensures this.nome == nome;
	public void setNome(String nome) {
		this.nome = nome;
	}

	public /*@ pure @*/ StatusDocumento getStatus() {
		return status;
	}

	//@ requires status.label == "Corrigido" || status.label == "Com Falhas" || status.label == "Aguardando correcao";
	//@ assignable this.status;
	//@ ensures this.status == status;
	public void setStatus(StatusDocumento status) {
		this.status = status;
	}

	public /*@ pure @*/ List<Contestacao> getContestacao() {
		return contestacoes;
	}

	//@ requires contestacao.size() > 0;
	//@ assignable this.contestacoes;
	//@ ensures this.contestacoes == contestacao; 
	public void setContestacao(List<Contestacao> contestacao) {
		this.contestacoes = contestacao;
	}

	public /*@ pure @*/ List<Correcao> getCorrecao() {
		return correcao;
	}
	
	//@ requires correcao.size() > 0;
	//@ assignable this.correcao;
	//@ ensures this.correcao == correcao; 
	public void setCorrecao(List<Correcao> correcao) {
		this.correcao = correcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
