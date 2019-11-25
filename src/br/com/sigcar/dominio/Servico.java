package br.com.sigcar.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sigcar.enums.TipoServico;

@Entity
@Table(name="servico") 
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private /*@ spec public @*/int id;
	
	private /*@ spec public @*/ boolean status;
	
	@Temporal(TemporalType.DATE)
	private /*@ spec public @*/ Date dataSolicitacao;
	
	private /*@ spec public @*/ String nomeEntidade;
	
	@ManyToOne
	private /*@ spec public @*/ Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	private /*@ spec public @*/ TipoServico tipoServico;
	
	@OneToMany
	private /*@ spec public @*/ List<Documento> documentos;

	public Servico() {
		
	}
	
	public int getId() {
		return id;
	}
	
	/*@ requires id != null;
	 *@ assignable this.id 
	 *@ ensures this.id == id;
	 */
	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean isAtivo() {
		return status;
	}
	
	/*@ requires boolean != null;
	 *@ assignable this.status;
	 *@ ensures this.status == status; 
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	/*@ requires dataSolicitacao != null;
	 *@ assignable this.dadaSolicitacao;
	 *@ ensures this.dataSolicitacao == dataSolicitacao; 
	 */
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}


	public String getNomeEntidade() {
		return nomeEntidade;
	}

	/*@ requires nomeEntidade != null;
	 *@ assignable this.nomeEntidade;
	 *@ ensures this.nomeEntidade == nomeEntidade;
	 */
	public void setNomeEntidade(String nomeEntidade) {
		this.nomeEntidade = nomeEntidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	/*@ requires usuario != null;
	 *@ assignable this.usuario;
	 *@ ensures this.usuario = usuario; 
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}
	
	/*@ requires documentos != null;
	 *@ assignable this.documentos;
	 *@ ensures this.documentos == documentos; 
	 */
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}
	
	/*@ requires tipoServico != null;
	 *@ assingnable this.tipoServico;
	 *@ ensures this.tipoServico == tipoServico; 
	 */
	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSolicitacao == null) ? 0 : dataSolicitacao.hashCode());
		result = prime * result + ((documentos == null) ? 0 : documentos.hashCode());
		result = prime * result + id;
		result = prime * result + ((nomeEntidade == null) ? 0 : nomeEntidade.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((tipoServico == null) ? 0 : tipoServico.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Servico other = (Servico) obj;
		if (dataSolicitacao == null) {
			if (other.dataSolicitacao != null)
				return false;
		} else if (!dataSolicitacao.equals(other.dataSolicitacao))
			return false;
		if (documentos == null) {
			if (other.documentos != null)
				return false;
		} else if (!documentos.equals(other.documentos))
			return false;
		if (id != other.id)
			return false;
		if (nomeEntidade == null) {
			if (other.nomeEntidade != null)
				return false;
		} else if (!nomeEntidade.equals(other.nomeEntidade))
			return false;
		if (status != other.status)
			return false;
		if (tipoServico != other.tipoServico)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
