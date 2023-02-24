package com.example.demo.services;

import com.example.demo.modelo.Cabana;
import com.example.demo.repositorios.CabanaRepository;
import com.example.demo.utiles.Iterable2ListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CabanasService {
    private final CabanaRepository cabanaRepository;

    public CabanasService(CabanaRepository cabanaRepository) {
        this.cabanaRepository = cabanaRepository;
    }

    public Optional<List<Cabana>> getCabanasByClimatizion(boolean filter) {
        Iterable<Cabana> allByClimatizadaEquals = cabanaRepository.findAllByClimatizadaIs(filter);
        return new Iterable2ListMapper<Cabana>().map(allByClimatizadaEquals);
    }

    public Optional<List<Cabana>> getCabanasByNameLongerThan(int length) {
        List<Cabana> stream = new Iterable2ListMapper<Cabana>().
                map(cabanaRepository.findAll()).get();
          return Optional.of(stream.stream().filter(
                  (c)->{
                      return c.getNombre().length()>length;
                  }).toList());
    }

    public Optional<List<Cabana>> getAll() {
        return new Iterable2ListMapper<Cabana>().map(cabanaRepository.findAll());
    }
}
