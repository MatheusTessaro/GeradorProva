package br.com.geradorprova.model.enumeration;

public enum TipoQuestao {
	ABERTA("Aberta"),
	ESCOLHA_UNICA("Escolha unica"), 
	ESCOLHA_MULTIPLA("Escolha multipla");
	
	private final String valor;

	private TipoQuestao(String valor) {
		this.valor = valor;
	}
	
    public String getValor() {
        return valor;
    }
	
}
