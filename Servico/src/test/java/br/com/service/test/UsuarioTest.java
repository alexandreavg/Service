package br.com.service.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.servico.dao.UsuarioDAO;
import br.com.servico.domain.Usuario;

public class UsuarioTest {
	
	@Ignore
	@Test
	public void buscarUsuario() {
		
		@SuppressWarnings("unused")
		Usuario usuario = new Usuario();
		
		UsuarioDAO testar = new UsuarioDAO();
		
		usuario = testar.LogarUsuario("alexandre-avg@hotmail.com", "abc123");
				
		System.out.println("TESTE EM PROGRESSO");
		
	}

}
