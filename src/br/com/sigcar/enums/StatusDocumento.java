package br.com.sigcar.enums;

public enum StatusDocumento {

	CORRIGIDO("Corrigido"),
	COM_FALHAS("Com falhas"),
	AGUARDANDO_CORRECAO("Aguardando correcao");

	private /*@ spec_public @*/String label;

	StatusDocumento(String label){
		this.label=label;
	}
	
	public String getLabel() {
		return label;
	}
}
