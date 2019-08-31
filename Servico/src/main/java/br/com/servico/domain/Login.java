package br.com.servico.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Login extends GenericDomain{
	
	private String email;
	private String senha;

	public Login(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Login() {
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
	
}
