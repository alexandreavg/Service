package br.com.servico.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Servico/rest
@ApplicationPath("rest")
public class ServicoResourceConfig extends ResourceConfig {
	public ServicoResourceConfig(){
		packages("br.com.servico.service");
	}
}
