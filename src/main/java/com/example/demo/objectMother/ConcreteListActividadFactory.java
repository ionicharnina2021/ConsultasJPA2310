package com.example.demo.objectMother;

import com.example.demo.modelo.Actividad;

import java.util.ArrayList;

public class ConcreteListActividadFactory extends AbstractListFactory<Actividad,String> {
    int duracionMax ;

    public ConcreteListActividadFactory(String[] elements, int duracionMax) {
        super(elements, new ArrayList<Actividad>());
        this.duracionMax = duracionMax;
    }

    @Override
    protected Actividad getNextElement(int i) {
        return new Actividad(elements[i],duracionMax);
    }
}
