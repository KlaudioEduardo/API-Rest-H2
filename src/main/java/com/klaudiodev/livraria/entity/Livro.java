package com.klaudiodev.livraria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_livro")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference // ✅ Evita loop no JSON
    private Autor autor;

    public Livro(Long id, String nome, Autor autor) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
    }
}
