package br.com.geradorprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long>{

}
