package br.com.geradorprova.model.enumeration;

public enum ProvaState {

	ABERTA("Aberta"),
	CORRIGIDA("Corrigida"),
	FINALIZADA("Finalizada");
	
	
	private String valor;

	private ProvaState(String valor) {
		this.valor = valor;
	}

	
	public String getValor() {
		return valor;
	}
}
