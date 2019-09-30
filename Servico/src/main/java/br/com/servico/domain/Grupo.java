package br.com.servico.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Grupo extends GenericDomain {

	@Column(length = 60, nullable = false)
	private String nomeGrupo;

	@Column(length = 60, nullable = false)
	private String nomeMateria;

	@Column(nullable = true)
	private Double notaGrupo;

	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario moderador;

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public Double getNotaGrupo() {
		return notaGrupo;
	}

	public void setNotaGrupo(Double notaGrupo) {
		this.notaGrupo = notaGrupo;
	}

	public Usuario getModerador() {
		return moderador;
	}

	public void setModerador(Usuario moderador) {
		this.moderador = moderador;
	}

}
