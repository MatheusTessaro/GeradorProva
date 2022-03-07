package br.com.geradorprova.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.Tag;
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
		
//		if(questao.getTipoQuestao().equals(TipoQuestao.ABERTA)) {
//			return;
//		}
//		
//		Set<Resposta> respostas = questao.getRespostas();
//		if(respostas != null && !respostas.isEmpty())
//		
//		for(Resposta resp : questao.getRespostas()) {
//			daoResposta.save(resp);
//		}
		
	}
	
	
	public List<Questao> listAll(){
		List<Questao> questoes = new ArrayList<>();
		
		questoes = daoQuestao.findAll();
		
		return questoes;
	}
	
	public Questao findById(Long id) {
		Questao questao = new Questao();
		
		questao = daoQuestao.findById(id).get();
		
		return questao;
	}
	
	public void delete(Long id) {
		
		daoQuestao.deleteById(id);
	}
	
	
	public List<Tag> findAllTags() {
		
		return daoTag.findAll();
	}
	
}
