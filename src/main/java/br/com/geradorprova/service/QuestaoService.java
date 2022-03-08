package br.com.geradorprova.service;

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
	}
	
	
	public List<Questao> listAll(){
		
		return daoQuestao.findAll();
	}
	
	public Questao findById(Long id) {
		
		return daoQuestao.findById(id).get();
	}
	
	public void delete(Long id) {
		
		daoQuestao.deleteById(id);
	}
	
	
	public List<Tag> findAllTags() {
		
		return daoTag.findAll();
	}
	
}
