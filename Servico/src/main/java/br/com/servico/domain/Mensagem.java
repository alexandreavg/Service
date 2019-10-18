package br.com.servico.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Mensagem extends GenericDomain {

	@Column(length = 60, nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn()
	private Grupo grupo = null;

	@Column(length = 60, nullable = false)
	private String mensagem;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar postagem;

	@Column(nullable = false)
	private Integer contadorSpam = 0;

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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
