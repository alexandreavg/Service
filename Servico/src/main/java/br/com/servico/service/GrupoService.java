package br.com.servico.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.servico.dao.GrupoDAO;
import br.com.servico.domain.Grupo;

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
	@SuppressWarnings("unused")
	@GET
	@Path("/listarTodosGrupos/")
	public String listarTodosGrupos() {
		List<Grupo> grupos = new ArrayList<Grupo>();
		Gson gson = new Gson();
		
		GrupoDAO grupoDAO = new GrupoDAO();
		return gson.toJson(grupos = grupoDAO.listar());
	}
	
	

}
