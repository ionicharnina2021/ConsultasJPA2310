package com.example.demo.ListFactory;

import com.example.demo.modelo.Grupo;

import java.util.ArrayList;
import java.util.Random;

public class ConcreteListGrupoFactory extends AbstractListFactory<Grupo,String>{

    String turnos[];

    public ConcreteListGrupoFactory(String[] elements, String[] turnos) {
        super(elements,new ArrayList<Grupo>());
        this.turnos = turnos;
    }


    @Override
    protected Grupo getNextElement(int i) {
        return new Grupo(elements[i],turnos[new Random().nextInt(turnos.length)]);
    }
}
