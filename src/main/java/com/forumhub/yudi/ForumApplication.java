package com.forumhub.yudi;

import com.forumhub.yudi.respository.UsuarioRepository;
import com.forumhub.yudi.usuario.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Bean
	public CommandLineRunner criarUsuarioTeste(UsuarioRepository repository, PasswordEncoder encoder) {
		return args -> {
			if(repository.findByLogin("yudi@email.com") == null) {
				var senhaHash = encoder.encode("123456");
				var usuario = new Usuario(null, "yudi@email.com", senhaHash);
				repository.save(usuario);
				System.out.println("Usuario teste criado: yudi@email.com / 123456");
			}
		};
	}
}
