package br.com.geradorprova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.repository.ProvaRepository;

@Service
public class ProvaService {
	
	@Autowired
	ProvaRepository daoProva;

	public List<Prova> listarProvasCadastradas(){
		
		List<Prova> provas = daoProva.findAll();
		
		return provas;
	}
}
