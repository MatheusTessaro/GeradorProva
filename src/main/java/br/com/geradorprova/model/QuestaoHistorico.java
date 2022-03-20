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

import br.com.geradorprova.model.enumeration.Dificuldade;
import br.com.geradorprova.model.enumeration.TipoQuestao;

@Entity
@Table(name = "tb_questao_historico")
public class QuestaoHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questao_historico")
	private Long idQuestaoHistorico;
	
	@Column
	private String enunciado;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_questao")
	private TipoQuestao tipoQuestao;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Dificuldade dificuldade;

	@Column(name = "id_prova")
	private Long idProva;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_questao_historico")
	private List<RespostaHistorico> respostas;
	
	@Column
	private Double valor;
	
	@Column
	private Double nota;
	
	@Transient
	private Integer acertou;
	
	public QuestaoHistorico parseQuestaoToHistorico() {
		
		return null;
	}
	

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

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public List<RespostaHistorico> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaHistorico> respostas) {
		this.respostas = respostas;
	}
	
	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Double getNota() {
		return nota;
	}


	public void setNota(Double nota) {
		this.nota = nota;
	}


	public Integer getAcertou() {
		return acertou;
	}


	public void setAcertou(Integer acertou) {
		this.acertou = acertou;
	}
	
}
