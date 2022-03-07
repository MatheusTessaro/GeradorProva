package br.com.geradorprova.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Questao;

@Transactional
public interface QuestaoRepository extends JpaRepository<Questao, Long> {
	
	
	List<Questao> findByIdTag(Long idTag);

}
