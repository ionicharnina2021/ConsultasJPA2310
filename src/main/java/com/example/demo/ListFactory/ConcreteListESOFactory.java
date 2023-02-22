package com.example.demo.ListFactory;

import com.example.demo.modelo.Eso;
import com.example.demo.modelo.Grupo;
import com.example.demo.modelo.Tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListESOFactory extends AbstractListFactory<Eso,String> {
    int edadMaxima = 16;
    int edadMinima = 11;
    List<Tienda> alojamiento;
    List<Grupo> grupos;

    public ConcreteListESOFactory(String[] elements, int edadMaxima, int edadMinima, List<Tienda> alojamiento, List<Grupo> grupos) {
       super(elements,new ArrayList<Eso>());
        this.edadMaxima = edadMaxima;
        this.edadMinima = edadMinima;
        this.alojamiento = alojamiento;
        this.grupos = grupos;
    }


    @Override
    protected Eso getNextElement(int i) {
        return new Eso(elements[i], new Random().nextInt(edadMaxima - edadMinima) + edadMinima, grupos.get(i % grupos.size()), alojamiento.get(i % alojamiento.size()));
    }
}
