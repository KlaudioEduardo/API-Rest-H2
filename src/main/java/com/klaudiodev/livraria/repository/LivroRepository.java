package com.klaudiodev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klaudiodev.livraria.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	

}
