package br.com.geradorprova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Usuario;
import br.com.geradorprova.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository daoUsuario; 
	
	public Usuario findUser(String login, String senha) {
		
		
		return daoUsuario.findByLoginAndSenha(login, senha);
	}
	
	
}
