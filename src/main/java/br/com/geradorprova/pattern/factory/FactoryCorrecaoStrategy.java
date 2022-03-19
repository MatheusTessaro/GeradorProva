package br.com.geradorprova.pattern.factory;

import java.util.Objects;

import br.com.geradorprova.pattern.strategy.CorrecaoQuestaoMultipla;
import br.com.geradorprova.pattern.strategy.CorrecaoQuestaoStrategy;
import br.com.geradorprova.pattern.strategy.CorrecaoQuestaoUnica;

public class FactoryCorrecaoStrategy {

	private static FactoryCorrecaoStrategy instance;
	
	private FactoryCorrecaoStrategy() {
		
	}
	
	//singleton
	public static FactoryCorrecaoStrategy getInstance() {
		if(Objects.isNull(instance)) {
			instance = new FactoryCorrecaoStrategy();
		}
		
		return instance;
	}
	
	public CorrecaoQuestaoStrategy createStrategy(String tipoQuestao) {
		
		CorrecaoQuestaoStrategy strategy = null;
		
		switch (tipoQuestao) {
			case "ESCOLHA_UNICA":
				strategy = new CorrecaoQuestaoUnica();
				break;
			case "ESCOLHA_MULTIPLA":
				strategy = new CorrecaoQuestaoMultipla();
				break;
			default:
				break;
			}
		
		return strategy;
	}
}
