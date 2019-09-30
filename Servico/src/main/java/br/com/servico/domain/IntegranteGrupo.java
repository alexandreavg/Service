package br.com.servico.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class IntegranteGrupo extends GenericDomain {
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario integrante;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Grupo grupo;

	public Usuario getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Usuario integrante) {
		this.integrante = integrante;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
