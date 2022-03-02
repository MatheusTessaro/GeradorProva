package br.com.geradorprova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private boolean respostaCorreta;
	
	@Column
	private boolean selecionado;

	@Column(name = "id_questao_historico")
	private Long idQuestao;

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

	public boolean isRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(boolean respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}
	
	
}
