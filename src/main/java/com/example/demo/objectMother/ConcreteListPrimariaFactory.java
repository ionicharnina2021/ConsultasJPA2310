package com.example.demo.objectMother;

import com.example.demo.modelo.Cabana;
import com.example.demo.modelo.Grupo;
import com.example.demo.modelo.Primaria;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListPrimariaFactory implements AbstractListFactory<Primaria> {
    String elements[] ;
    ArrayList<Primaria> arrayList = new ArrayList<>();
    int edadMaxima ;
    int edadMinima ;
    List<Cabana> alojamiento;
    List<Grupo> grupos;

    public ConcreteListPrimariaFactory(String[] elements, int edadMaxima, int edadMinima, List<Cabana> alojamiento, List<Grupo> grupos) {
        this.elements = elements;
        this.edadMaxima = edadMaxima;
        this.edadMinima = edadMinima;
        this.alojamiento = alojamiento;
        this.grupos = grupos;
    }

    @Override
    public List<Primaria> getList() {

        for (int i = 0; i < elements.length; i++) {
            Primaria elemento = new Primaria(elements[i], new Random().nextInt(edadMaxima - edadMinima) + edadMinima, grupos.get(i % grupos.size()), alojamiento.get(i % alojamiento.size()));
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
