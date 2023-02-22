package com.example.demo.ListFactory;

import com.example.demo.modelo.Tienda;

import java.util.ArrayList;
import java.util.Random;

public class ConcreteListTiendaFactory extends AbstractListFactory<Tienda,String>{
    int temperaturaMinima;

    public ConcreteListTiendaFactory(String[] elements, int temperaturaMinima) {
        super(elements,new ArrayList<Tienda>());
        this.elements = elements;
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    protected Tienda getNextElement(int i) {
        return  new Tienda(elements[i], new Random().nextInt(temperaturaMinima) + 1);
    }
}
