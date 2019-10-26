package br.com.servico.service;

import org.junit.Test;

import com.google.gson.Gson;

import br.com.servico.dao.GrupoDAO;
import br.com.servico.dao.UsuarioDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.IntegranteGrupo;
import br.com.servico.domain.Usuario;

public class IntegranteGrupoServiceTeste {
	
	
	@Test
	public void gerarJson() {
	
		IntegranteGrupo integranteGrupo = new IntegranteGrupo();
		
		Usuario integrante = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		integrante = usuarioDAO.buscar(3L);
		
		
		Grupo grupo = new Grupo();
		GrupoDAO grupoDAO = new GrupoDAO();
		grupo = grupoDAO.buscar(1L);
		
		integranteGrupo.setAtivo(true);
		integranteGrupo.setGrupo(grupo);
		integranteGrupo.setIntegrante(integrante);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(integranteGrupo));
		
	}

}
