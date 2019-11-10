package br.com.servico.util;

import javax.crypto.spec.SecretKeySpec;

import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class CriptografiaUtil {

	static String IV = "AAAAAAAAAAAAAAAA";
	static String textopuro = "Olá mundo! Esse é um texto que foi cifrado em AES 16 bit.";
	static String chaveencriptacao = "0123456789abcdef";

	public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
		Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return encripta.doFinal(textopuro.getBytes("UTF-8"));
	}

	public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception {
		Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(decripta.doFinal(textoencriptado), "UTF-8");
	}

}
