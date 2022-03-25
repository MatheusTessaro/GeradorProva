package br.com.geradorprova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorprova.model.Tag;
import br.com.geradorprova.repository.TagRepository;

@Service @Transactional
public class TagService {
	
	@Autowired
	TagRepository daoTag;
	
	
	
	public void save(Tag tag) {
		
		daoTag.save(tag);
	}
	
	public void delete(Long id) {
		
		daoTag.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Tag> list() {
		
		return daoTag.findAll();
	}
	
	@Transactional(readOnly = true)
	public Tag findById(Long id) {
		
		return daoTag.findById(id).get();
	}

}
