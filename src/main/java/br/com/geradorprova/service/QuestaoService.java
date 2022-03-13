package br.com.geradorprova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.Tag;
import br.com.geradorprova.repository.QuestaoRepository;
import br.com.geradorprova.repository.TagRepository;

@Service @Transactional
public class QuestaoService {
	
	@Autowired
	QuestaoRepository daoQuestao;
	
	@Autowired
	TagRepository daoTag;

	public void save(Questao questao) {
		
		daoQuestao.save(questao);
	}
	
	public void delete(Long id) {
		
		daoQuestao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Questao> listAll(){
		
		return daoQuestao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Questao findById(Long id) {
		
		return daoQuestao.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Tag> findAllTags() {
		
		return daoTag.findAll();
	}
	
}
