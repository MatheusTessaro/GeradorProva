package br.com.geradorprova.model;

import java.util.ArrayList;
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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
	
	@Column
	@Enumerated(EnumType.STRING)
	private ProvaStatus status;
	
	@Column
	private String tag;
	
	@Column
	private Double nota;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_prova")
	private List<QuestaoHistorico> questoes = new ArrayList<>();
	
	@Transient
	private Long idTag;
	
	@Transient
	private Integer qtdeFacil = 0;
	
	@Transient
	private Integer qtdeMedio = 0;
	
	@Transient
	private Integer qtdeDificil = 0;

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

	public Long getIdTag() {
		return idTag;
	}
	
	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public ProvaStatus getStatus() {
		return status;
	}

	public void setStatus(ProvaStatus status) {
		this.status = status;
	}


	public List<QuestaoHistorico> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<QuestaoHistorico> questoes) {
		this.questoes = questoes;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getQtdeFacil() {
		return qtdeFacil;
	}

	public void setQtdeFacil(Integer qtdeFacil) {
		this.qtdeFacil = qtdeFacil;
	}

	public Integer getQtdeMedio() {
		return qtdeMedio;
	}

	public void setQtdeMedio(Integer qtdeMedio) {
		this.qtdeMedio = qtdeMedio;
	}

	public Integer getQtdeDificil() {
		return qtdeDificil;
	}

	public void setQtdeDificil(Integer qtdeDificil) {
		this.qtdeDificil = qtdeDificil;
	}
	
	public Integer getNumeroQuestoes() {
		return qtdeDificil + qtdeMedio + qtdeFacil;
	}
	
}
