package br.com.servico.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

import com.google.gson.Gson;

import br.com.servico.dao.UsuarioDAO;
import br.com.servico.domain.Login;
import br.com.servico.domain.Usuario;

//http://127.0.0.1:8080/Servico/rest/usuario/listarUsuarios
@Path("usuario")
public class UsuarioService {

	@GET
	@Path("/listarUsuarios/")
	public String listarUsuarios() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarios = (List<Usuario>) usuarioDAO.listar();
		Gson gson = new Gson();

		String json = gson.toJson(usuarios);

		return json;
	}

	@SuppressWarnings("unused")
	@PUT
	@Path("/salvarUsuario/")
	public String salvarUsuario(String json) {

		String jsonRetorno = "";

		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		// usuario.setSenha(hash.toHex());

		usuario = usuarioDAO.salvar(usuario);

		return jsonRetorno = gson.toJson(usuario);

	}

	@GET
	@Path("/consultaUsuario/{codigo}")
	public String consultarUsuario(@PathParam("codigo" )int codigo) {
		String jsonRetorno = "";

		Gson gson = new Gson();

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = (List<Usuario>) usuarioDAO.listar();
		Usuario result = null;
		  
		for (Usuario usuario : usuarios) {
		   if (usuario.getCodigo() == codigo) {
			   result = usuario;
			   break;
		   }
		}
		  
		if (result == null) {
		   throw new WebApplicationException(404);
		}
		  
		return jsonRetorno = gson.toJson(result);
	}
	
	
	@GET
	@Path("/logar/")
	public String logarUsuario(String json) {
		String jsonRetorno = "";
		Gson gson = new Gson();
		Login permissao = gson.fromJson(json, Login.class);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarios = (List<Usuario>) usuarioDAO.listar();
		Usuario result = null;
		  
		for (Usuario usuario : usuarios) {
		   if (usuario.getEmail().equals(permissao.getEmail()) && usuario.getSenha().equals(permissao.getSenha())) {
			   result = usuario;
			   break;
		   }
		}
		  
		if (result == null) {
			return "Usuario null";
		}
		
		
		return jsonRetorno = gson.toJson(result);
	}
	
	/**
	 * @author Alexandre
	 * @param nome
	 * @return
	 * Metodo que retorna lista de usuarios por nome.
	 */
	@SuppressWarnings("unused")
	@GET
	@Path("/consultaUsuarioPorNome/{nome}")
	public String bucarUsuarioPorNome(@PathParam("nome") String json) {
		String jsonRetorno = "";
		Gson gson = new Gson();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarios = usuarioDAO.listarPorNome(json);
		
		return jsonRetorno = gson.toJson(usuarios);
	}

}
