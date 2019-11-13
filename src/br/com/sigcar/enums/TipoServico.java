package br.com.sigcar.enums;

public enum TipoServico {

	REGISTRAR("Registrar"),
	ATUALIZAR("Atualizar");

	private String label;

	TipoServico(String label){
		this.label=label;
	}
	
	public String getLabel() {
		return label;
	}
}
