package br.example.iofood;

import br.example.iofood.infrastructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class IofoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IofoodApplication.class, args);
	}

}
