package com.notificacao;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificacaoApplication {

	public static void main(String[] args) {
		Dotenv.configure().systemProperties().load();

		SpringApplication.run(NotificacaoApplication.class, args);
	}
}