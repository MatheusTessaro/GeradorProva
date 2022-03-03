package br.com.geradorprova.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.Resposta;
import br.com.geradorprova.model.enumeration.TipoQuestao;
import br.com.geradorprova.repository.QuestaoRepository;
import br.com.geradorprova.repository.RespostaRepository;

@Service
public class QuestaoService {
	
	@Autowired
	QuestaoRepository daoQuestao;
	
	@Autowired
	RespostaRepository daoResposta;

	public void save(Questao questao) {
		
		daoQuestao.save(questao);
		
		if(questao.getTipoQuestao().equals(TipoQuestao.ABERTA)) {
			return;
		}
		
		Set<Resposta> respostas = new HashSet<>();
		
		for(Resposta resp : questao.getRespostas()) {
			daoResposta.save(resp);
		}
		
	}
}
