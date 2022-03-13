package br.com.geradorprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
	

}
