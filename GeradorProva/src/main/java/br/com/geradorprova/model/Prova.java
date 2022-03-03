package br.com.geradorprova.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_prova")
public class Prova {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prova")
	private Long idProva;

	@Column
	private String materia;
	
	@Column
	private String titulo;
	
	@Column
	private Integer finalizada;

	@Column
	private Integer corrigida;
	
	@OneToMany
	private Set<Questao> questoes;
	

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Integer finalizada) {
		this.finalizada = finalizada;
	}

	public Integer getCorrigida() {
		return corrigida;
	}

	public void setCorrigida(Integer corrigida) {
		this.corrigida = corrigida;
	}

	public Set<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}
	
	
}
