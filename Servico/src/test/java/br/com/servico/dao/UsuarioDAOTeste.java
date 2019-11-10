package br.com.servico.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import br.com.servico.domain.Usuario;

public class UsuarioDAOTeste {
	
	@Test
	public void passarSenhasMd5() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios = usuarioDAO.listar();
		
		for(Usuario usuario : usuarios) {
			usuario.setSenha(converterSenha(usuario.getSenha()));
			usuarioDAO.merge(usuario);
		}
		
	}
	
	private String converterSenha(String senha) {	
		return DigestUtils.md5Hex(senha).toUpperCase();
	}
	

}
