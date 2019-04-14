package br.com.servico.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.servico.dao.UsuarioDAO;
import br.com.servico.domain.Usuario;

//http://127.0.0.1:8080/Servico/rest/usuario
@Path("usuario")
public class UsuarioService {

	@GET
	public String logarUsuario() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarios = (List<Usuario>) usuarioDAO.listar();
		Gson gson = new Gson();
		
		String json = gson.toJson(usuarios);
		
		return json;
	}
	
}
