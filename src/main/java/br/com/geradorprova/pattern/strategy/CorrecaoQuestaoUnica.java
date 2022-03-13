package br.com.geradorprova.pattern.strategy;

import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.RespostaHistorico;

public class CorrecaoQuestaoUnica implements CorrecaoQuestaoStrategy{

	@Override
	public Double corrigir(QuestaoHistorico questao) {
		
		for(RespostaHistorico resp : questao.getRespostas()) {
			if(resp.getRespostaCorreta() == 1 && resp.getSelecionado() == 1) {
				
				return questao.getValor();
			}
		}
		
		return 0.0;		
	}

}
