package com.example.demo.objectMother;

import com.example.demo.modelo.Actividad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListActividadFactory implements AbstractListFactory<Actividad> {
    String[] elements;
    int duracionMax ;
    ArrayList<Actividad> arrayList = new ArrayList<>();

    public ConcreteListActividadFactory(String[] elements, int duracionMax) {
        this.elements = elements;
        this.duracionMax = duracionMax;
    }


    @Override
    public List<Actividad> getList() {
        for (int i = 0; i < elements.length; i++) {
            Actividad elemento = new Actividad(elements[i], new Random().nextInt(duracionMax) + 1);
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
