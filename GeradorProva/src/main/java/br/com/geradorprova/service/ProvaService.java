package br.com.geradorprova.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.Resposta;
import br.com.geradorprova.model.RespostaHistorico;
import br.com.geradorprova.model.enumeration.TipoQuestao;
import br.com.geradorprova.repository.ProvaRepository;
import br.com.geradorprova.repository.QuestaoRepository;

@Service
public class ProvaService {
	
	@Autowired
	ProvaRepository daoProva;
	
	@Autowired
	QuestaoRepository daoQuestao;
	
	public void generate(Prova prova) {
		//se for possivel update tem que fazer um if verificando se idProva == null.
		
		List<QuestaoHistorico> questoesProva = new ArrayList<>();
		
		List<Questao> questoes = daoQuestao.findByIdTag(prova.getIdTag());
		Collections.shuffle(questoes);
		questoesProva.addAll(parseQuestaoToHistorico(questoes.subList(0, prova.getNumeroQuestoes())));
		
		prova.setQuestoes(questoesProva);
		
		daoProva.save(prova);
		
	}
	
	
	
	public List<Prova> listAll() {
		List<Prova> provas = new ArrayList<>();
		provas = daoProva.findAll();
		
		
		return provas;
	}
	

	public Prova findById(Long id) {
		
		return daoProva.findById(id).get();
	}
	
	
	public void delete(Long id) {
		
		daoProva.deleteById(id);
		
	}
	
	
	
	public Prova autoRectify(Long id) {
		
		Prova prova = daoProva.findById(id).get();
		
		for(QuestaoHistorico q : prova.getQuestoes()) {
			if(q.getTipoQuestao().equals(TipoQuestao.ABERTA)) {
				continue;
			}else if(q.getTipoQuestao().equals(TipoQuestao.ESCOLHA_UNICA)) {
				q.setNota(verifyEscolhaUnica(q));
			}else if(q.getTipoQuestao().equals(TipoQuestao.ESCOLHA_MULTIPLA)) {
				q.setNota(verifyEscolhaMultipla(q));
			}
		}
		
		return prova;
	}
	
	private Double verifyEscolhaUnica(QuestaoHistorico questao) {
		
		Double nota = 0.0;
		
		for(RespostaHistorico resp : questao.getRespostas()) {
			if(resp.getRespostaCorreta() == 1 && resp.getSelecionado() == 1) {
				nota = questao.getValor();
				break;
			}else {
				continue;
			}
		}
		
		return nota;
	}
	
	private Double verifyEscolhaMultipla(QuestaoHistorico questao) {
		
		Double nota = 0.0;
		Double notaAlternativa = questao.getValor() / questao.getRespostas().size();
		
		for(RespostaHistorico resp : questao.getRespostas()) {
			if(resp.getRespostaCorreta() == 1 && resp.getSelecionado() == 1) {
				nota += notaAlternativa;
			}else if(resp.getSelecionado() == 1){
				nota -= notaAlternativa;
			}
		}
		
		if(nota < 0)
			return 0.0;
		
		return nota;
	}
	
	
	private List<QuestaoHistorico> parseQuestaoToHistorico(List<Questao> questoes) {
		List<QuestaoHistorico> questaoHistorico = new ArrayList<>();
		
		int qtdeQuestoes = questoes.size();
		
		for(Questao q : questoes) {
			QuestaoHistorico qH = new QuestaoHistorico();
			qH.setEnunciado(q.getEnunciado());
			qH.setTipoQuestao(q.getTipoQuestao());
			qH.setDificuldade(q.getDificuldade());
			qH.setValor((double) (100 / qtdeQuestoes));
			qH.setRespostas(parseRespostaToHistorico(q.getRespostas()));
		}
		
		return questaoHistorico;
	}
	
	private List<RespostaHistorico> parseRespostaToHistorico(List<Resposta> respostas) {
		List<RespostaHistorico> respostaHistorico  = new ArrayList<>();
		
		for(Resposta res : respostas) {
			RespostaHistorico resH = new RespostaHistorico();
			resH.setResposta(res.getResposta());
			resH.setRespostaCorreta(res.getRespostaCorreta());
			respostaHistorico.add(resH);
		}
		
		return respostaHistorico;
	}
	
}
