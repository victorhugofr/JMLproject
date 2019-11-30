package br.com.sigcar.dominio;

public class Endereco {
	private /*@ spec_public @*/ String cep;
	private /*@ spec_public @*/ String logradouro;
	private /*@ spec_public @*/ String complemento;
	private /*@ spec_public @*/ String bairro;
	private /*@ spec_public @*/ String localidade;
	private /*@ spec_public @*/ String uf;
	private /*@ spec_public @*/ String unidade;
	private /*@ spec_public @*/ String ibge;
	private /*@ spec_public @*/ String gia;
	
	public String getCep() {
		return cep;
	}
	//@ requires cep != null;
	//@ assignable this.cep;
	//@ ensures this.cep == cep;
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	//@ requires logradouro != null;
	//@ assignable this.logradouro;
	//@ ensures this.logradouro == logradouro;
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	//@ requires complemento != null;
	//@ assignable this.complemento;
	//@ ensures this.complemento == complemento;
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	//@ requires bairro != null;
	//@ assignable this.bairro;
	//@ ensures this.bairro == bairro;
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	//@ requires localidade != null;
	//@ assignable this.localidade; 
	//@ ensures this.localidade == localidade;
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	
	//@ requires uf != null;
	//@ assignable this.uf;
	//@ ensures this.uf == uf;
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getUnidade() {
		return unidade;
	}
	
	//@ requires unidade != null;
	//@ assignable this.unidade;
	//@ ensures this.unidade == unidade;
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getIbge() {
		return ibge;
	}
	
	//@ requires ibge != null;
	//@ assignable this.ibge;
	//@ ensures this.ibge == ibge;
	public void setIbge(String ibge) {
		this.ibge = ibge;
	}
	public String getGia() {
		return gia;
	}
	
	//@ requires gia != null;
	//@ assignable this.gia;
	//@ ensures this.gia == gia;
	public void setGia(String gia) {
		this.gia = gia;
	}
}
