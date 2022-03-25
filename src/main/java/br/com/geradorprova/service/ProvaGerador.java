package br.com.geradorprova.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.Resposta;
import br.com.geradorprova.model.RespostaHistorico;
import br.com.geradorprova.model.enumeration.Dificuldade;
import br.com.geradorprova.model.enumeration.ProvaState;
import br.com.geradorprova.repository.QuestaoRepository;

@Component
public class ProvaGerador {
	
	@Autowired
	QuestaoRepository daoQuestao;
	
	Gson gson = new GsonBuilder().create();
	
	public Prova generate(Prova prova) {
		
		List<QuestaoHistorico> questoesProva = new ArrayList<>();
		
		List<Questao> questoes = daoQuestao.findByIdTag(prova.getIdTag());// <- busca todas as questoes cadastradas que contenham uma determinada tag
		prova.setTag(questoes.get(0).getTag().getNome());
		
		Collections.shuffle(questoes);// <- embaralha a lista de questoes.
		
		//separa a lista de questoes por dificuldade.
		List<Questao> questoesFaceis = questoes.stream().filter(q -> q.getDificuldade().equals(Dificuldade.FACIL)).collect(Collectors.toList());
		List<Questao> questoesMedias = questoes.stream().filter(q -> q.getDificuldade().equals(Dificuldade.MEDIO)).collect(Collectors.toList());
		List<Questao> questoesDificeis = questoes.stream().filter(q -> q.getDificuldade().equals(Dificuldade.DIFICIL)).collect(Collectors.toList());
		
		//pega uma sub-lista da lista de questoes por dificuldade e converte para o objeto historico
		questoesProva.addAll(addQuestaoToHistorico(questoesFaceis.subList(0, prova.getQtdeFacil())));
		questoesProva.addAll(addQuestaoToHistorico(questoesMedias.subList(0, prova.getQtdeMedio())));
		questoesProva.addAll(addQuestaoToHistorico(questoesDificeis.subList(0, prova.getQtdeDificil())));
		
		//seta as questoes dentro do objeto prova, ja calculando o valor de cada questao.
		prova.setQuestoes(calcValorQuestao(prova,  questoesProva));
		
		prova.setState(ProvaState.ABERTA);

		return prova;
		
	}

	private List<QuestaoHistorico> addQuestaoToHistorico(List<Questao> questoes) {
		List<QuestaoHistorico> questoesHistorico = new ArrayList<>();
		
		for(Questao questao : questoes) {
			String tmp = gson.toJson(questao); //<- converte cada questao para json
			QuestaoHistorico qh = gson.fromJson(tmp, QuestaoHistorico.class); // <- converte o json para o historico
			qh.setRespostas(addRespostaToHistorico(questao.getRespostas()));
			questoesHistorico.add(qh);
		}
		
		return questoesHistorico;
	}
	
	private List<RespostaHistorico> addRespostaToHistorico(List<Resposta> respostas) {
		List<RespostaHistorico> respostaHistorico  = new ArrayList<>();
		
		for (Resposta res : respostas) {
	        String tmp = gson.toJson(res); // <- converte cada resposta para json
	        respostaHistorico.add(gson.fromJson(tmp,RespostaHistorico.class)); // <- converte o json para o historico
	    }
		
		return respostaHistorico;
	}
	
	private List<QuestaoHistorico> calcValorQuestao(Prova prova, List<QuestaoHistorico> questoesProva) {
		
		double valor;
		// facil = 1; medio = 1.5; dificil = 2;
		valor = prova.getQtdeFacil() + (prova.getQtdeMedio() * 1.5) + (prova.getQtdeDificil() * 2); //<- calcula o peso total da prova
		valor = 100 / valor; //<- calcula o valor por peso.
		
		//distribui o valor de acordo com a dificuldade(peso) de cada questão.
		for(QuestaoHistorico q : questoesProva) {
			if(q.getDificuldade().equals(Dificuldade.FACIL)) 
				q.setValor(valor);
			else if(q.getDificuldade().equals(Dificuldade.MEDIO))
				q.setValor(valor*1.5);
			else if(q.getDificuldade().equals(Dificuldade.DIFICIL))
				q.setValor(valor*2);
		}
		
		return questoesProva;
	}
	
}
