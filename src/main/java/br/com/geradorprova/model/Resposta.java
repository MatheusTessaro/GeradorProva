package br.com.geradorprova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_resposta")
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resposta")
	private Long idResposta;
	
	@Column
	private String resposta;
	
	@Column(name = "resposta_correta")
	private Integer respostaCorreta = 0;

	@Column(name = "id_questao")
	private Long idQuestao;
	
	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
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

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

}
