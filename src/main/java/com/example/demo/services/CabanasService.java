package com.example.demo.services;

import com.example.demo.modelo.Cabana;
import com.example.demo.repositorios.CabanaRepository;
import com.example.demo.utiles.OptionalListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabanasService {
    private final CabanaRepository cabanaRepository;

    public CabanasService(CabanaRepository cabanaRepository) {
        this.cabanaRepository = cabanaRepository;
    }

    public Optional<List<Cabana>> getCabanasByClimatizion(boolean filter) {
        Optional<Iterable<Cabana>> allByClimatizadaIs = cabanaRepository.findAllByClimatizadaIs(filter);
        Iterable<Cabana> cabanas = allByClimatizadaIs.get();
        Optional<List<Cabana>> map = new OptionalListMapper<Cabana>().map(cabanas);
        return map;
    }

    public Optional<List<Cabana>> getAll() {
        return new OptionalListMapper<Cabana>().map(cabanaRepository.findAll());
    }
}
