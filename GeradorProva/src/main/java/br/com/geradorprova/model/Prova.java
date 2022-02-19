package br.com.geradorprova.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_prova")
public class Prova {
	
	@Id
	@Column(name = "id_prova")
	private Long idProva;

	@Column
	private String materia;
	
	@Column
	private String titulo;
	
	@Column
	private Integer is_finalizada;

	@Column
	private Integer is_corrigida;
	
	@Transient
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

	public Integer getIs_finalizada() {
		return is_finalizada;
	}

	public void setIs_finalizada(Integer is_finalizada) {
		this.is_finalizada = is_finalizada;
	}

	public Integer getIs_corrigida() {
		return is_corrigida;
	}

	public void setIs_corrigida(Integer is_corrigida) {
		this.is_corrigida = is_corrigida;
	}

	public Set<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}
	
	
}
