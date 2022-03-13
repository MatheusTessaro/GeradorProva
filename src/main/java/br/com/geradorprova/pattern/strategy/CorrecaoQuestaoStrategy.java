package br.com.geradorprova.pattern.strategy;

import br.com.geradorprova.model.QuestaoHistorico;

public interface CorrecaoQuestaoStrategy {

	public Double corrigir(QuestaoHistorico questao);
}
