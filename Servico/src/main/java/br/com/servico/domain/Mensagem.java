package br.com.servico.domain;

import java.util.Calendar;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Mensagem extends GenericDomain {
	
	private Usuario usuario;
	//private Grupo grupo;
	private String mensagem;
	private Calendar postagem;
	private Integer contadorSpam = 0;
	
	public Mensagem(Usuario usuario, String mensagem, Calendar postagem) {
		this.usuario = usuario;
		this.mensagem = mensagem;
		this.postagem = postagem;
	}

	public Mensagem() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
