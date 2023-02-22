package com.example.demo.objectMother;

import com.example.demo.modelo.Eso;
import com.example.demo.modelo.Grupo;
import com.example.demo.modelo.Tienda;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListESOFactory implements AbstractListFactory<Eso> {
    String elements[] = {"Ramonazo", "Lusiazo", "Enriquazo", "Manolazo", "Juanazo", "Juliazo", "Alfonsazo", "Teresiazo", "Anazo", "Estebancazo", "Pilarcazo", "Luciiazo", "Vicentazo"};
    ArrayList<Eso> arrayList = new ArrayList<>();
    int edadMaxima = 16;
    int edadMinima = 11;
    List<Tienda> alojamiento;
    List<Grupo> grupos;

    public ConcreteListESOFactory(String[] elements, int edadMaxima, int edadMinima, List<Tienda> alojamiento, List<Grupo> grupos) {
        this.elements = elements;
        this.edadMaxima = edadMaxima;
        this.edadMinima = edadMinima;
        this.alojamiento = alojamiento;
        this.grupos = grupos;
    }

    @Override
    public List<Eso> getList() {
        for (int i = 0; i < elements.length; i++) {
            Eso elemento = new Eso(elements[i], new Random().nextInt(edadMaxima - edadMinima) + edadMinima, grupos.get(i % grupos.size()), alojamiento.get(i % alojamiento.size()));
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
