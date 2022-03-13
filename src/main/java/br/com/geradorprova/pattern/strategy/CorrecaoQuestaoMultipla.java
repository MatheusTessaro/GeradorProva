package br.com.geradorprova.pattern.strategy;

import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.RespostaHistorico;

public class CorrecaoQuestaoMultipla implements CorrecaoQuestaoStrategy{

	@Override
	public Double corrigir(QuestaoHistorico questao) {
		
		Double nota = 0.0;
		Double notaAlternativa = questao.getValor() / questao.getRespostas().stream().filter(r -> r.getRespostaCorreta() == 1).count();
		
		for(RespostaHistorico resp : questao.getRespostas()) {
			if(resp.getRespostaCorreta() == 1 && resp.getSelecionado() == 1) {
				nota += notaAlternativa;
			}else if(resp.getSelecionado() == 1){
				nota -= notaAlternativa;
			}
		}
		
		if(nota < 0)
			return 0.0;
		
		return nota;
	}

}
