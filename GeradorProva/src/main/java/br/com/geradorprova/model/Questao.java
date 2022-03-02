package br.com.geradorprova.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.geradorprova.model.enumeration.Dificuldade;
import br.com.geradorprova.model.enumeration.TipoQuestao;

@Entity
@Table(name = "tb_questao")
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questao")
	private Long idQuestao;
	
	@Column(length = 100)
	private String enunciado;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_questao")
	private TipoQuestao tipoQuestao;
	
	@Column
	private Dificuldade dificuldade;

	@Column(name = "id_tag")
	private Integer idTag;
	
	@ManyToOne
	@JoinColumn
	private Tag tag;
	
	@OneToMany
	private Set<Resposta> respostas;
	
	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
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

	public Integer getIdTag() {
		return idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}
	
}
