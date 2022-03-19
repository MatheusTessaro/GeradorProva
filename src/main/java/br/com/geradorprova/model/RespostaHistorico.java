package br.com.geradorprova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tb_resposta_historico")
public class RespostaHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resposta_historico")
	private Long idRespostaHistorico;
	
	@Column
	private String resposta;
	
	@Column(name = "resposta_correta")
	private Integer respostaCorreta = 0;
	
	@Column
	private Integer selecionado = 0;

	@Column(name = "id_questao_historico")
	private Long idQuestaoHistorico;

	public Long getIdRespostaHistorico() {
		return idRespostaHistorico;
	}

	public void setIdRespostaHistorico(Long idRespostaHistorico) {
		this.idRespostaHistorico = idRespostaHistorico;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Integer getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(Integer respostaCorreta) {
		if(respostaCorreta == null)
			this.respostaCorreta = 0;
		else
			this.respostaCorreta = respostaCorreta;
	}

	public Integer getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Integer selecionado) {
		if(selecionado == null) 
			this.selecionado = 0;
		else
			this.selecionado = selecionado;
	}

	public Long getIdQuestaoHistorico() {
		return idQuestaoHistorico;
	}

	public void setIdQuestaoHistorico(Long idQuestaoHistorico) {
		this.idQuestaoHistorico = idQuestaoHistorico;
	}

	
}
