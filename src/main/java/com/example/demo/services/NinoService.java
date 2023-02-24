package com.example.demo.services;

import com.example.demo.modelo.Nino;
import com.example.demo.modelo.Primaria;
import com.example.demo.repositorios.EsoRepository;
import com.example.demo.repositorios.NinoRepository;
import com.example.demo.repositorios.PrimariaREpository;
import com.example.demo.utiles.Iterable2ListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinoService {

    private final NinoRepository ninoRepository;
    private final PrimariaREpository primariaREpository;
    private final EsoRepository esoRepository;


    public NinoService(NinoRepository ninoRepository, PrimariaREpository primariaREpository, EsoRepository esoRepository) {
        this.ninoRepository = ninoRepository;
        this.primariaREpository = primariaREpository;
        this.esoRepository = esoRepository;
    }

    public Optional<List<Nino>> findAllNino(){
        return new Iterable2ListMapper<Nino>().map(ninoRepository.findAll());
    }
    public Optional<List<Primaria>> findAllPrimaria(){
        return new Iterable2ListMapper<Primaria>().map(primariaREpository.findAll());
    }

    public Optional<List<Nino>> getByEdadBetween(int younger,int older){
       return new Iterable2ListMapper<Nino>().map(ninoRepository.findAllByEdadBetween(younger, older));
    }
}
