package br.com.servico.pojo;

import br.com.servico.domain.GenericDomain;

@SuppressWarnings("serial")
public class IntegranteGrupoPojo extends GenericDomain {
	
	private Long usuario;
	private Long grupo;
	private boolean ativo;
	
	public IntegranteGrupoPojo() {
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getGrupo() {
		return grupo;
	}

	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


}
