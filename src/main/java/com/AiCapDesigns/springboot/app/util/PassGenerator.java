package com.AiCapDesigns.springboot.app.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGenerator {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		
		//El string que mandamos al metodo encode es la contraseña que vamos a encriptar
		System.out.println(bCryptPasswordEncoder.encode("1234"));
	}

}
