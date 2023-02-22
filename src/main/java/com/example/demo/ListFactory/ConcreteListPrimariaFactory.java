package com.example.demo.ListFactory;

import com.example.demo.modelo.Cabana;
import com.example.demo.modelo.Grupo;
import com.example.demo.modelo.Primaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListPrimariaFactory extends AbstractListFactory<Primaria,String> {
    int edadMaxima ;
    int edadMinima ;
    List<Cabana> alojamiento;
    List<Grupo> grupos;

    public ConcreteListPrimariaFactory(String[] elements, int edadMaxima, int edadMinima, List<Cabana> alojamiento, List<Grupo> grupos) {
       super(elements,new ArrayList<Primaria>());
        this.edadMaxima = edadMaxima;
        this.edadMinima = edadMinima;
        this.alojamiento = alojamiento;
        this.grupos = grupos;
    }

    @Override
    protected Primaria getNextElement(int i) {
        return  new Primaria(elements[i], new Random().nextInt(edadMaxima - edadMinima) + edadMinima, grupos.get(i % grupos.size()), alojamiento.get(i % alojamiento.size()));
    }
}
