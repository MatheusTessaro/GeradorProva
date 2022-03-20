package br.com.geradorprova.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.model.Tag;
import br.com.geradorprova.model.enumeration.ProvaStatus;
import br.com.geradorprova.repository.ProvaRepository;
import br.com.geradorprova.repository.TagRepository;

@Service @Transactional
public class ProvaService{
	
	@Autowired
	ProvaRepository daoProva;
	
	@Autowired
	TagRepository daoTag;
	
	@Autowired
	ProvaGerador gerador;
	
	@Autowired
	ProvaCorrecao correcao;
	
	public void save(Prova prova) {
		if(Objects.isNull(prova.getStatus())) {
			prova = gerador.generate(prova);
		}else if(prova.getStatus().equals(ProvaStatus.ABERTA)) {
			prova.setStatus(ProvaStatus.FINALIZADA);
		}else if(prova.getStatus().equals(ProvaStatus.FINALIZADA)) {
			prova.setStatus(ProvaStatus.CORRIGIDA);
			prova = correcao.calcNotaProva(prova);
		}
		
		daoProva.save(prova);
	}
	
	public Prova rectify(Long id) {
		
		Prova prova = daoProva.findById(id).get();
		
		return correcao.autoRectify(prova);
	}
	
	@Transactional(readOnly = true)
	public List<Prova> listAll() {
		
		return daoProva.findAll();
	}
	
	@Transactional(readOnly = true)
	public Prova findById(Long id) {
		
		return daoProva.findById(id).get();
	}
	
	public void delete(Long id) {
		
		daoProva.deleteById(id);
	}
	
	public List<Tag> findAllTags() {
		
		return daoTag.findAll();
	}
	
}
