package br.com.servico.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//http://127.0.0.1:8080/Servico/rest/hello
@Path("hello")
public class ServicoService {
	@GET
	public String exibir() {
		return "Esta Funcionando!";
	}
}
