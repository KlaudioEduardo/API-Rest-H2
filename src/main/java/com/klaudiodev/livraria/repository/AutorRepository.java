package com.klaudiodev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klaudiodev.livraria.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
