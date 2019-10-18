package br.com.servico.service;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.google.gson.Gson;

import br.com.servico.dao.GrupoDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.Mensagem;
import br.com.servico.domain.Usuario;

public class GrupoServiceTeste {
	
	@Test
	public void gerarJson() {
		Gson gson = new Gson();
		
		Grupo grupo = new Grupo();
		Usuario moderador = new Usuario();
		
		moderador.setCurso("Ads");
		moderador.setEmail("alexandre@gemail.com");
		moderador.setNome("Alexandre");
		moderador.setSemestre("6");
		moderador.setSenha("abc123");
		moderador.setSobreNome("V. Garcia");
		
		grupo.setNomeGrupo("Grupo para Teste");
		grupo.setNomeMateria("Matematica");
		grupo.setNotaGrupo(10.0);
		grupo.setModerador(moderador);
		
		String mensagem = gson.toJson(grupo);
		
		System.out.println(mensagem);
		
		Grupo grupoQueVeioDoJson = new Grupo();
		
		grupoQueVeioDoJson = gson.fromJson(mensagem, Grupo.class);
		
		System.out.println(grupoQueVeioDoJson.getNomeGrupo());
				
	}
	
}
