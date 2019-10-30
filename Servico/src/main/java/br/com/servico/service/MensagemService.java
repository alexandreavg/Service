package br.com.servico.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.servico.dao.MensagemDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.Mensagem;
import br.com.servico.domain.Usuario;
import br.com.servico.pojo.MensagemPojo;

/*
 * Author: Robson Lopes
 * Data: 13/10/19
 * Classe de serviços para app android com funcionamento de um Fórum
 */

//http://127.0.0.1:8080/Servico/rest/mensagem
@Path("mensagem")
public class MensagemService {

	/*	Robson Lopes
	 * 	13/10/19
	 *  Método para retornar as mensagens enviadas para o grupo
	*/
	@POST
	@Path("/listarMensagens/")
	public String listarMensagens(String json) {
		Gson gson = new Gson();
		MensagemDAO dao = new MensagemDAO();
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		
		Grupo grupo = gson.fromJson(json, Grupo.class);
		
		mensagens = dao.retornarMensagensDoGrupo(grupo);
		
		return gson.toJson(mensagens);
	}
	
	@POST
	@Path("/salvarMensagem")
	public String enviarMensagem(String json) {
		Gson gson = new Gson();
		MensagemDAO dao = new MensagemDAO();
		Mensagem mensagem = gson.fromJson(json, Mensagem.class);	
		dao.salvar(mensagem);
		return gson.toJson(mensagem);
	}
	
	@POST
	@Path("/enviarMensagem")
	public String enviarMensagemForum(String json) {
		Gson gson = new Gson();
		MensagemDAO dao = new MensagemDAO();
		
		MensagemPojo mensagemPojo = gson.fromJson(json, MensagemPojo.class);
		Grupo grupo = gson.fromJson(new GrupoService().consultargrupo(mensagemPojo.getCodigoGrupo()), Grupo.class);
		Usuario usuario = gson.fromJson(new UsuarioService().consultarUsuario(mensagemPojo.getUsuario()), Usuario.class);
		
		Mensagem mensagem = new Mensagem();
		mensagem.setContadorSpam(0);
		mensagem.setGrupo(grupo);
		mensagem.setMensagem(mensagemPojo.getMensagem());
		mensagem.setPostagem(mensagemPojo.getPostagem());
		mensagem.setUsuario(usuario);
		
		dao.salvar(mensagem);
		return gson.toJson(mensagem);
	}

}	
