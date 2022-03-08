package br.com.geradorprova.model.enumeration;

public enum Dificuldade {

	FACIL("Fácil"), 
	MEDIO("Médio"), 
	DIFICIL("Difícil");
	
	private String valor;

	private Dificuldade(String valor) {
		this.valor = valor;
	}

	
	public String getValor() {
		return valor;
	}
	
}
