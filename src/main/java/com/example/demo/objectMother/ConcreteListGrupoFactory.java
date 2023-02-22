package com.example.demo.objectMother;

import com.example.demo.modelo.Grupo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListGrupoFactory implements AbstractListFactory<Grupo>{
    ArrayList<Grupo> arrayList = new ArrayList<>();
    String elements[] ;
    String turnos[];

    public ConcreteListGrupoFactory(String[] elements, String[] turnos) {
        this.elements = elements;
        this.turnos = turnos;
    }

    @Override
    public List<Grupo> getList() {
        for (int i = 0; i < elements.length; i++) {
            Grupo elemento = new Grupo(elements[i], turnos[new Random().nextInt(turnos.length)]);
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
