package br.com.geradorprova.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.QuestaoHistorico;
import br.com.geradorprova.model.Resposta;
import br.com.geradorprova.model.RespostaHistorico;
import br.com.geradorprova.model.Tag;
import br.com.geradorprova.model.enumeration.Dificuldade;
import br.com.geradorprova.model.enumeration.ProvaStatus;
import br.com.geradorprova.model.enumeration.TipoQuestao;
import br.com.geradorprova.pattern.factory.FactoryCorrecaoStrategy;
import br.com.geradorprova.pattern.strategy.CorrecaoQuestaoStrategy;
import br.com.geradorprova.repository.ProvaRepository;
import br.com.geradorprova.repository.QuestaoRepository;
import br.com.geradorprova.repository.TagRepository;

@Service @Transactional
public class ProvaService {
	
	@Autowired
	ProvaRepository daoProva;
	
	@Autowired
	QuestaoRepository daoQuestao;
	
	@Autowired
	TagRepository daoTag;
	
	Gson gson = new GsonBuilder().create();
	
	public void save(Prova prova) {
		if(prova.getStatus().equals(ProvaStatus.ABERTA)) {
			prova.setStatus(ProvaStatus.FINALIZADA);
		}else if(prova.getStatus().equals(ProvaStatus.FINALIZADA)) {
			prova.setStatus(ProvaStatus.CORRIGIDA);
			Double nota = 0.00;
			for(QuestaoHistorico questao : prova.getQuestoes()) {
				nota += questao.getNota();
			}
			prova.setNota(BigDecimal.valueOf(nota).setScale(1, RoundingMode.HALF_EVEN).doubleValue());
		}
		
		daoProva.save(prova);
	}
	
	
	public void generate(Prova prova) {
		
		List<QuestaoHistorico> questoesProva = new ArrayList<>();
		
		List<Questao> questoes = daoQuestao.findByIdTag(prova.getIdTag());
		prova.setTag(questoes.get(0).getTag().getNome());
		
		Collections.shuffle(questoes);
		
		List<Questao> questoesFaceis = questoes.stream().filter(q -> q.getDificuldade().equals(Dificuldade.FACIL)).collect(Collectors.toList());
		List<Questao> questoesMedias = questoes.stream().filter(q -> q.getDificuldade().equals(Dificuldade.MEDIO)).collect(Collectors.toList());
		List<Questao> questoesDificeis = questoes.stream().filter(q -> q.getDificuldade().equals(Dificuldade.DIFICIL)).collect(Collectors.toList());
		
		questoesProva.addAll(addQuestaoToHistorico(questoesFaceis.subList(0, prova.getQtdeFacil())));
		questoesProva.addAll(addQuestaoToHistorico(questoesMedias.subList(0, prova.getQtdeMedio())));
		questoesProva.addAll(addQuestaoToHistorico(questoesDificeis.subList(0, prova.getQtdeDificil())));
		
		prova.setQuestoes(calcValorQuestao(prova,  questoesProva));
		
		prova.setStatus(ProvaStatus.ABERTA);

		daoProva.save(prova);
		
	}
	
	
	public Prova autoRectify(Long id) {
		
		Prova prova = daoProva.findById(id).get();
		
		CorrecaoQuestaoStrategy correcaoStrategy; 
		
		FactoryCorrecaoStrategy factory = new FactoryCorrecaoStrategy();

		for(QuestaoHistorico questao : prova.getQuestoes()) {
			
			correcaoStrategy = factory.createStrategy(questao.getTipoQuestao().toString());
			correcaoStrategy.corrigir(questao);
		}
		
		return prova;
	}
	
	private List<QuestaoHistorico> addQuestaoToHistorico(List<Questao> questoes) {
		List<QuestaoHistorico> questoesHistorico = new ArrayList<>();
		
		for(Questao questao : questoes) {
			String tmp = gson.toJson(questao);
			QuestaoHistorico qh = gson.fromJson(tmp, QuestaoHistorico.class);
			qh.setRespostas(addRespostaToHistorico(questao.getRespostas()));
			questoesHistorico.add(qh);
		}
		
		return questoesHistorico;
	}
	
	private List<RespostaHistorico> addRespostaToHistorico(List<Resposta> respostas) {
		List<RespostaHistorico> respostaHistorico  = new ArrayList<>();
		
		for (Resposta res : respostas) {
	        String tmp = gson.toJson(res);
	        respostaHistorico.add(gson.fromJson(tmp,RespostaHistorico.class));
	    }
		
		return respostaHistorico;
	}
	
	private List<QuestaoHistorico> calcValorQuestao(Prova prova, List<QuestaoHistorico> questoesProva) {
		
		double valor;
		
		valor = prova.getQtdeFacil() + (prova.getQtdeMedio() * 1.5) + (prova.getQtdeDificil() * 2);
		valor = 100 / valor;
		
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

	
	@Transactional(readOnly = true)
	public List<Prova> listAll() {
		
		return daoProva.findAll();
	}
	
	@Transactional(readOnly = true)
	public Prova findById(Long id) {
		
		return daoProva.findById(id).get();
	}
	
	public void delete(Long id) {
		
		daoProva.deleteById(id);
	}
	
	public List<Tag> findAllTags() {
		
		return daoTag.findAll();
	}
	
}
