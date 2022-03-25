package br.com.geradorprova.pattern.strategy;

import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.RespostaHistorico;

public class CorrecaoQuestaoMultipla implements CorrecaoQuestaoStrategy{

	@Override
	public Double corrigir(QuestaoHistorico questao) {
		
		Double nota = 0.0;
		//valorQuestao dividido pela quantidade de alternativas corretas = valor por alternativa
		Double notaAlternativa = questao.getValor() / questao.getRespostas().stream().filter(r -> r.getRespostaCorreta() == 1).count(); 
		
		//se uma alternativa foi selecionada e é a resposta correta, adiciona o valor da alternativa à nota.
		//se foi selecionado porem não é a resposta correta, subtrai da nota o valor da alternativa.
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
