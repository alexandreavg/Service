package br.com.servico.service;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.servico.domain.Usuario;
import sun.misc.BASE64Decoder;

//http://127.0.0.1:8080/Servico/rest/login
@Path("login")
public class LoginService {

	@GET
    @Path("/login/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getUserById(@PathParam("codigo") Integer id, 
                            @HeaderParam("authorization") String authString){
         
        if(!isUserAuthenticated(authString)){
            return "{\"error\":\"User not authenticated\"}";
        }
        
        Usuario usuario = new Usuario("Testador1", "Silva", "teste@yahoo.com", "123", "Agro", "5");

        return usuario;
    }
     
    private boolean isUserAuthenticated(String authString){
        
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
         
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return true;
    }
    
    /*
    @GET
    @Path("teste")
    public String login(Login login){
    	return "Olá Mundo!";
    }*/
	
}
