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
	
//	DAO<Tag> dao = new DAO<>(Tag.class);
	
	
	public void save(Tag tag) {
		
//		dao.abrirT().incluirT(tag).fecharT();
		
		daoTag.save(tag);
	}
	
	public void delete(Long id) {
		
		daoTag.deleteById(id);
	}

	
	public List<Tag> list() {
		List<Tag> tags = new ArrayList<>();
		
		tags = daoTag.findAll();
		
		return tags;
	}
	
	public Tag findById(Long id) {
		
		return daoTag.findById(id).get();
	}

}
