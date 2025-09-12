package com.klaudiodev.livraria.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.klaudiodev.livraria.entity.Autor;
import com.klaudiodev.livraria.entity.Livro;
import com.klaudiodev.livraria.repository.AutorRepository;
import com.klaudiodev.livraria.repository.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public void run(String... args) throws Exception {

		Autor a1 = new Autor(null, "Klaudio");
		Autor a2 = new Autor(null, "Victor");

		autorRepository.saveAll(Arrays.asList(a1, a2));

		Livro l1 = new Livro(null, "Senhor dos Aneis", a1);
		Livro l2 = new Livro(null, "Codigo Limpo", a2);

		livroRepository.saveAll(Arrays.asList(l1, l2));
	}

}
