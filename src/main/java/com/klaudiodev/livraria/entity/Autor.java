package com.klaudiodev.livraria.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_autor")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "autor")
    @JsonManagedReference // ✅ Controla o lado "pai" da relação no JSON
    private List<Livro> livros = new ArrayList<>();

    public Autor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
