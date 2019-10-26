package br.com.servico.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.servico.dao.IntegranteGrupoDAO;
import br.com.servico.domain.IntegranteGrupo;
import br.com.servico.domain.Usuario;

//http://127.0.0.1:8080/Servico/rest/integranteGrupo/salvarIntegranteGrupo
@Path("integranteGrupo")
public class IntegranteGrupoService {
	
	@PUT
	@Path("/salvarIntegranteGrupo/")
	public String salvarUsuarioGrupo(String json) {
		
		String jsonRetorno = "";

		Gson gson = new Gson();
		IntegranteGrupo integranteGrupo = gson.fromJson(json, IntegranteGrupo.class);

		IntegranteGrupoDAO integranteGrupoDAO = new IntegranteGrupoDAO();
		
		integranteGrupo = integranteGrupoDAO.salvar(integranteGrupo);
		
		jsonRetorno = gson.toJson(integranteGrupo);
		
		return jsonRetorno;
	}
	
	@POST
	@Path("/removerOuAtivarIntegranteGrupo/")
	public String removerOuAtivarIntegranteGrupo(String json) {
		
		String jsonRetorno = "";
		
		Gson gson = new Gson();
		IntegranteGrupo integranteGrupo = gson.fromJson(json, IntegranteGrupo.class);

		IntegranteGrupoDAO integranteGrupoDAO = new IntegranteGrupoDAO();
		
		integranteGrupo = integranteGrupoDAO.merge(integranteGrupo);
		
		jsonRetorno = gson.toJson(integranteGrupo);
		
		return jsonRetorno;
	}
	
	@POST
	@Path("/buscarGrupoPorIntegrante/")
	public String buscarGrupoPorIntegrante(String json) {
		
		String jsonRetorno = "";
		
		Gson gson = new Gson();
		Usuario integrante = gson.fromJson(json, Usuario.class);

		IntegranteGrupoDAO integranteGrupoDAO = new IntegranteGrupoDAO();
		
		List<IntegranteGrupo> integranteGrupos = integranteGrupoDAO.listarPorIntegrante(integrante);
		
		jsonRetorno = gson.toJson(integranteGrupos);
		
		return jsonRetorno;
		
	}

}
