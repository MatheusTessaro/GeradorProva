package br.com.geradorprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geradorprova.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
	Usuario findByLoginAndSenha(String login, String senha);
}
