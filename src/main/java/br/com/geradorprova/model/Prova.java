package br.com.geradorprova.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.geradorprova.model.enumeration.ProvaStatus;

@Entity
@Table(name = "tb_prova")
public class Prova {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prova")
	private Long idProva;
	
	@Column
	private String titulo;
	
//	@Column
//	private Integer finalizada;
//
//	@Column
//	private Integer corrigida;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ProvaStatus status;
	
	@Transient
	private Long idTag;
	
	@Column
	private Double nota;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_prova")
	private List<QuestaoHistorico> questoes;
	
	@Transient
	private Integer numeroQuestoes;

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

//	public Integer getFinalizada() {
//		return finalizada;
//	}
//
//	public void setFinalizada(Integer finalizada) {
//		this.finalizada = finalizada;
//	}
//
//	public Integer getCorrigida() {
//		return corrigida;
//	}
//
//	public void setCorrigida(Integer corrigida) {
//		this.corrigida = corrigida;
//	}
	
	public Long getIdTag() {
		return idTag;
	}

	public ProvaStatus getStatus() {
		return status;
	}

	public void setStatus(ProvaStatus status) {
		this.status = status;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public List<QuestaoHistorico> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<QuestaoHistorico> questoes) {
		this.questoes = questoes;
	}

	public Integer getNumeroQuestoes() {
		return numeroQuestoes;
	}

	public void setNumeroQuestoes(Integer numeroQuestoes) {
		this.numeroQuestoes = numeroQuestoes;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
}
