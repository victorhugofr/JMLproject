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
	private int id;
	
	@Enumerated(EnumType.STRING)
	private StatusDocumento status;
	
	private String observacao;
	
	@OneToMany
	private List<Contestacao> contestacoes;
	
	@OneToMany
	private List<Correcao> correcao;
	
	private String nome;

	@Column(columnDefinition="text")
	private String arquivoBase64;
	
	private String extensao; //pdf,docx
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] arquivoBase64Original;
	
	
	public String getArquivoBase64() {
		return arquivoBase64;
	}

	public void setArquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public byte[] getArquivoBase64Original() {
		return arquivoBase64Original;
	}

	public void setArquivoBase64Original(byte[] arquivoBase64Original) {
		this.arquivoBase64Original = arquivoBase64Original;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusDocumento getStatus() {
		return status;
	}

	public void setStatus(StatusDocumento status) {
		this.status = status;
	}

	public List<Contestacao> getContestacao() {
		return contestacoes;
	}

	public void setContestacao(List<Contestacao> contestacao) {
		this.contestacoes = contestacao;
	}

	public List<Correcao> getCorrecao() {
		return correcao;
	}

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
