package br.com.servico.service;

import java.util.Calendar;

import org.junit.Test;

import com.google.gson.Gson;

import br.com.servico.dao.GrupoDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.Mensagem;
import br.com.servico.domain.Usuario;

public class MensagemServiceTeste {
	
	@Test
	public void gerarJson() {
		
		Gson gson = new Gson();
		
		Mensagem mensagem = new Mensagem();
		Grupo grupo = new Grupo();
		GrupoDAO grupodao = new GrupoDAO();
		grupo = grupodao.buscar(1L);
		
		
		mensagem.setContadorSpam(0);
		mensagem.setGrupo(grupo);
		mensagem.setMensagem("MEnsagem de teste 123");
		mensagem.setPostagem(Calendar.getInstance());
		mensagem.setUsuario(grupo.getModerador());
		
		String mensagemJson = gson.toJson(mensagem);
		
		System.out.println(mensagemJson);

	}
	
}
