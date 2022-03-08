package br.com.geradorprova.model.enumeration;

public enum ProvaStatus {

	CORRIGIDA("Corrigida"),
	FINALIZADA("Finalizada");
	
	
	private String valor;

	private ProvaStatus(String valor) {
		this.valor = valor;
	}

	
	public String getValor() {
		return valor;
	}
}
