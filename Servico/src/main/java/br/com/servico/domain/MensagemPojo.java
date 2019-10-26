package br.com.servico.domain;

import java.util.Calendar;

@SuppressWarnings("serial")
public class MensagemPojo extends GenericDomain {
	
	private Long usuario;
	private Long grupo;
	private String mensagem;
	private Calendar postagem;
	private Integer contadorSpam = 0;
	
	
	public Long getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	public Long getCodigoGrupo() {
		return grupo;
	}
	public void setCodigoGrupo(Long codigoGrupo) {
		this.grupo = codigoGrupo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Calendar getPostagem() {
		return postagem;
	}
	public void setPostagem(Calendar postagem) {
		this.postagem = postagem;
	}
	public Integer getContadorSpam() {
		return contadorSpam;
	}
	public void setContadorSpam(Integer contadorSpam) {
		this.contadorSpam = contadorSpam;
	}


}
