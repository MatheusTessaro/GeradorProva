package br.com.geradorprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
