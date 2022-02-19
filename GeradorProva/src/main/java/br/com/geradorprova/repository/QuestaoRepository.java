package br.com.geradorprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
