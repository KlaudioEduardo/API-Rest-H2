package com.klaudiodev.livraria.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.klaudiodev.livraria.entity.Autor;
import com.klaudiodev.livraria.repository.AutorRepository;
import com.klaudiodev.livraria.service.exception.EntityNotFound;

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

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public Autor create(Autor obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Autor getId(Long id){
        Optional<Autor> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Autor de ID: "+id+" não encontrado!");
        }
        return obj.get();
    }

    public List<Autor> getAll(){
        return repository.findAll();
    }

    public Autor update(Autor obj){
        Optional<Autor> newObj = repository.findById(obj.getId());
        if (newObj.isEmpty()){
            throw new EntityNotFound("Autor de ID: "+obj.getId()+" não encontrado!");
        }
        updateAutor(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateAutor(Optional<Autor> newObj, Autor obj) {
        newObj.get().setNome(obj.getNome());
    }
}