package com.example.demo.ListFactory;

import com.example.demo.modelo.Cabana;

import java.util.ArrayList;

public class ConcreteListCabanaFactory extends AbstractListFactory<Cabana,String>{

    boolean[] climatizadas;

    public ConcreteListCabanaFactory(String[] elements,boolean[] climatizadas) {
        super(elements, new ArrayList<Cabana>());
        this.climatizadas=climatizadas;
    }

    @Override
    protected Cabana getNextElement(int i) {
        return new Cabana(elements[i],climatizadas[i]);
    }
}
