package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Cabana;

import java.util.Optional;

public interface CabanaRepository extends CrudRepository<Cabana, Long> {
//cabanas que estan climatizadas o no
    public Optional<Iterable<Cabana>> findAllByClimatizadaIs(boolean climatizada);
}
