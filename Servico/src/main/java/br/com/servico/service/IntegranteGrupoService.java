package br.com.servico.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.servico.dao.IntegranteGrupoDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.IntegranteGrupo;
import br.com.servico.domain.Usuario;
import br.com.servico.pojo.IntegranteGrupoPojo;

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
	
	@POST
	@Path("/cadastraIntegranteGrupo/")
	public String cadastrarUsuarioGrupo(String json) {
		
		String jsonRetorno = "";

		Gson gson = new Gson();
		IntegranteGrupoPojo integranteGrupoPojo = gson.fromJson(json, IntegranteGrupoPojo.class);
		IntegranteGrupo integranteGrupo = new IntegranteGrupo();
		IntegranteGrupoDAO integranteGrupoDAO = new IntegranteGrupoDAO();
		GrupoService grupoService = new GrupoService();
		UsuarioService usuarioService = new UsuarioService();
		
		integranteGrupo.setAtivo(true);
		integranteGrupo.setGrupo(gson.fromJson(grupoService.consultargrupo(integranteGrupoPojo.getGrupo()),Grupo.class));
		integranteGrupo.setIntegrante(gson.fromJson(usuarioService.consultarUsuario(integranteGrupoPojo.getUsuario()), Usuario.class));

		
		integranteGrupoDAO.salvar(integranteGrupo);
		
		jsonRetorno = gson.toJson(integranteGrupo);
		
		return jsonRetorno;
	}
	
	@POST
	@Path("/consultarCadastroIntegranteGrupo/")
	public String consultarCadastroIntegranteGrupo(String json) {
		
		String jsonRetorno = "";
		Gson gson = new Gson();
		IntegranteGrupoPojo integranteGrupoPojo = gson.fromJson(json, IntegranteGrupoPojo.class);
		IntegranteGrupo integranteGrupo = new IntegranteGrupo();
		IntegranteGrupoDAO integranteGrupoDAO = new IntegranteGrupoDAO();
		GrupoService grupoService = new GrupoService();
		UsuarioService usuarioService = new UsuarioService();
		
		integranteGrupo.setAtivo(true);
		integranteGrupo.setGrupo(gson.fromJson(grupoService.consultargrupo(integranteGrupoPojo.getGrupo()),Grupo.class));
		integranteGrupo.setIntegrante(gson.fromJson(usuarioService.consultarUsuario(integranteGrupoPojo.getUsuario()), Usuario.class));
		
		boolean link = integranteGrupoDAO.consultarCadastroIntegranteGrupo(integranteGrupo);
		
		integranteGrupoPojo.setAtivo(link);

		jsonRetorno = gson.toJson(integranteGrupoPojo);

		return jsonRetorno;
	}
}
