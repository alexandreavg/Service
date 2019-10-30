package br.com.servico.service;

import org.junit.Test;

import com.google.gson.Gson;

import br.com.servico.pojo.IntegranteGrupoPojo;

public class IntegranteGrupoPojoTeste {
	
	@Test
	public void teste(){
		IntegranteGrupoPojo grupoPojo = new IntegranteGrupoPojo();
		grupoPojo.setAtivo(true);
		grupoPojo.setUsuario(2L);
		grupoPojo.setGrupo(2L);
		
		Gson gson = new Gson();
		String msg = gson.toJson(grupoPojo);
		System.out.println(msg);
	}

}
