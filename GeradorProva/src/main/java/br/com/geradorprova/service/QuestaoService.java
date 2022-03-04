package br.com.geradorprova.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.Resposta;
import br.com.geradorprova.model.Tag;
import br.com.geradorprova.model.enumeration.TipoQuestao;
import br.com.geradorprova.repository.QuestaoRepository;
import br.com.geradorprova.repository.RespostaRepository;
import br.com.geradorprova.repository.TagRepository;

@Service
public class QuestaoService {
	
	@Autowired
	QuestaoRepository daoQuestao;
	
	@Autowired
	RespostaRepository daoResposta;
	
	@Autowired
	TagRepository daoTag;

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
	
	
	public List<Questao> listAll(){
		List<Questao> questoes = new ArrayList<>();
		
		questoes = daoQuestao.findAll();
		
		for(Questao questao : questoes) {
			Tag tag = new Tag();
			tag = daoTag.findById(questao.getIdTag()).get();
			questao.set_tag(tag.getNome());
		}
		
		return questoes;
	}
	
}
