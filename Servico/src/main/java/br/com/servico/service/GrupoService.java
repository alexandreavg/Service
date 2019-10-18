package br.com.servico.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

import com.google.gson.Gson;

import br.com.servico.dao.GrupoDAO;
import br.com.servico.dao.UsuarioDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.Usuario;

//http://127.0.0.1:8080/Servico/rest/grupo
@Path("grupo")
public class GrupoService {
	
	/**
	 * @author Alexandre V. Garcia
	 * @return
	 * 
	 * Metodo que retorna todos os Grupos do sistema.
	 */
	//http://127.0.0.1:8080/Servico/rest/grupo/listarTodosGrupos/
	@GET
	@Path("/listarTodosGrupos/")
	public String listarTodosGrupos() {
		List<Grupo> grupos = new ArrayList<Grupo>();
		Gson gson = new Gson();
		
		GrupoDAO grupoDAO = new GrupoDAO();
		grupos = grupoDAO.listar();
		return gson.toJson(grupos);
	}
	
	/**
	 * @author Alexandre V. Garcia
	 * @param JSON Grupo
	 * @return
	 * 
	 * Metodo para salvar um novo grupo no sistema.
	 */
	@PUT
	@Path("/salvarGrupo/")
	public String salvarGrupo(String json) {
		
		Gson gson = new Gson();
		GrupoDAO grupoDAO = new GrupoDAO();
		
		Grupo grupo = gson.fromJson(json, Grupo.class);
		
		grupo = grupoDAO.salvar(grupo);
		
		return gson.toJson(grupo);
	}
	
	/**
	 * @author Alexandre V.Garcia
	 * @param JSON Grupo
	 * @return Lista de Grupos
	 * 
	 * Passa um nome de uma materia e retorna todos os grupos que contenham aquele nome.
	 * Obs: Pode passar o Grupo com o somente o nome da materia
	 */
	//http://127.0.0.1:8080/Servico/rest/grupo/listarGrupoPorMateria/
	@POST
	@Path("/listarGrupoPorMateria/")
	public String listarGrupoPorMateria(String json) {
		
		Gson gson = new Gson();
		GrupoDAO grupoDAO = new GrupoDAO();
		
		Grupo grupo = gson.fromJson(json, Grupo.class);
		
		List<Grupo> grupos = grupoDAO.listarGrupoPorMateria(grupo.getNomeMateria());
		
		return gson.toJson(grupos);
	}
	
	/**
	 * @author Alexandre V.Garcia
	 * @param JSON USUARIO
	 * @return Lista de Grupos
	 * 
	 * Passa um nome de um moderador e retorna todos os grupos que contenham aquele nome.
	 * Obs: pode passar o objeto Usuario apenas com o nome preenchido.
	 */
	//http://127.0.0.1:8080/Servico/rest/grupo/listarGrupoPorModerador/
	@POST
	@Path("/listarGrupoPorModerador/")
	public String listarGrupoPorModerador(String json) {
		
		Gson gson = new Gson();
		GrupoDAO grupoDAO = new GrupoDAO();
		
		Usuario usuario = gson.fromJson(json, Usuario.class);
		
		List<Grupo> grupos = grupoDAO.listarGrupoPorModerador(usuario.getNome());
		
		return gson.toJson(grupos);
	}
	
	@GET
	@Path("/consultagrupo/{codigo}")
	public String consultargrupo(@PathParam("codigo" )Long codigo) {
		String jsonRetorno = "";

		Gson gson = new Gson();

		GrupoDAO grupoDAO = new GrupoDAO();
		Grupo result = grupoDAO.buscar(codigo);
		  
		return jsonRetorno = gson.toJson(result);
	}

	
	

}
