package br.com.geradorprova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.geradorprova.model.enumeration.Dificuldade;
import br.com.geradorprova.model.enumeration.TipoQuestao;

@Entity
@Table(name = "tb_questao_historico")
public class QuestaoHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questao_historico")
	private Long idQuestaoHistorico;
	
	
	@Column(length = 100)
	private String enunciado;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_questao")
	private TipoQuestao tipoQuestao;
	
	@Column
	private Dificuldade dificuldade;

	@Column
	private Tag tag;

	public Long getIdQuestaoHistorico() {
		return idQuestaoHistorico;
	}

	public void setIdQuestaoHistorico(Long idQuestaoHistorico) {
		this.idQuestaoHistorico = idQuestaoHistorico;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public TipoQuestao getTipoQuestao() {
		return tipoQuestao;
	}

	public void setTipoQuestao(TipoQuestao tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
}
