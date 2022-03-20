package br.com.geradorprova.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.enumeration.TipoQuestao;
import br.com.geradorprova.pattern.factory.FactoryCorrecaoStrategy;
import br.com.geradorprova.pattern.strategy.CorrecaoQuestaoStrategy;
import br.com.geradorprova.repository.ProvaRepository;

@Component
public class ProvaCorrecao {

	@Autowired
	ProvaRepository daoProva;
	
	public Prova autoRectify(Prova prova) {
		
		CorrecaoQuestaoStrategy correcaoStrategy; 
		
		FactoryCorrecaoStrategy factory = FactoryCorrecaoStrategy.getInstance();

		for(QuestaoHistorico questao : prova.getQuestoes()) {
			if(questao.getTipoQuestao().equals(TipoQuestao.ABERTA)) {
				continue; // <- ignora as questões que são abertas.
			}
			
			correcaoStrategy = FactoryCorrecaoStrategy.getInstance().createStrategy(questao.getTipoQuestao().toString());
			questao.setNota(correcaoStrategy.corrigir(questao));
		}
		
		return prova;
	}
	
	public Prova calcNotaProva(Prova prova) {
		
		Double nota = 0.00;
		for(QuestaoHistorico questao : prova.getQuestoes()) {
			if(questao.getTipoQuestao().equals(TipoQuestao.ABERTA)) {
				if(questao.getAcertou() == 1) {
					questao.setNota(questao.getValor());
				}else if(questao.getAcertou() == 0) {
					questao.setNota(0.0);
				}
			}
			nota += questao.getNota();
		}
		prova.setNota(BigDecimal.valueOf(nota).setScale(1, RoundingMode.HALF_EVEN).doubleValue());
		
		return prova;
	}
	
}
