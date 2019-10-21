package br.com.servico.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.servico.dao.MensagemDAO;
import br.com.servico.domain.Grupo;
import br.com.servico.domain.Mensagem;

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
		
		mensagens = dao.retornarMensagensDoGrupo(grupo.getNomeGrupo());
		
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

}	
