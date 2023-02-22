package com.example.demo.objectMother;

import com.example.demo.modelo.Tienda;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListTiendaFactory implements AbstractListFactory<Tienda>{
    String elements[];
    ArrayList<Tienda> arrayList = new ArrayList<>();
    int temperaturaMinima;

    public ConcreteListTiendaFactory(String[] elements, int temperaturaMinima) {
        this.elements = elements;
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public List<Tienda> getList() {
        for (int i = 0; i < elements.length; i++) {
            Tienda elemento = new Tienda(elements[i], new Random().nextInt(temperaturaMinima) + 1);
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
