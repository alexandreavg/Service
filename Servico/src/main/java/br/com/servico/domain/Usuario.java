package br.com.servico.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 180, nullable = false)
	private String sobreNome;

	@Column(length = 60, nullable = false)
	private String email;

	@Column(length = 32, nullable = false)
	private String senha;

	@Column(length = 32, nullable = false)
	private String curso;

	@Column(length = 32, nullable = false)
	private String semestre;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
