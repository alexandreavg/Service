package br.com.servico.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CriptoUtilTeste {
	
	@Test
	public void cifrar() {
	    String hash = "35454B055CC325EA1AF2126E27707052";
	    String password = "ILoveJava";
	 
	    String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
	    
	    if(md5Hex.equals(hash)) {
	    	System.out.println("Iguais");
	    } else {
	    	System.out.println("Diferentes");
	    }
	    
	}

}
