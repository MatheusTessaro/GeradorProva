package br.com.geradorprova.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Tag;
import br.com.geradorprova.repository.TagRepository;

@Service
public class TagService {
	
	@Autowired
	TagRepository daoTag;
	
	
	public void saveTag(Tag tag) {
		
		daoTag.save(tag);
	}
	
	public void deleteTag(Long id) {
		
		daoTag.deleteById(id);
	}
	
	public void updateTag(Tag tag) {
		
		daoTag.save(tag);
	}
	
	public List<Tag> listTag() {
		List<Tag> tags = new ArrayList<>();
		
		tags = daoTag.findAll();
		
		return tags;
	}
	
	public Tag findById(Long id) {
		
		return daoTag.findById(id).get();
	}

}
