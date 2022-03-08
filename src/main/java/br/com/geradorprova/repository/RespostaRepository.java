package br.com.geradorprova.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Resposta;

@Transactional
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
