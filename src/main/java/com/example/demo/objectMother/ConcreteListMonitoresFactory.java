package com.example.demo.objectMother;

import com.example.demo.modelo.Monitor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class ConcreteListMonitoresFactory implements AbstractListFactory<Monitor>{
    String elements[] = {"Lolo", "Aullador", "Choricete", "Tenedor", "Morretes"};
    ArrayList<Monitor> arrayList = new ArrayList<>();

    public ConcreteListMonitoresFactory(String[] elements) {
        this.elements = elements;
    }

    @Override
    public List<Monitor> getList() {
        for (int i = 0; i < elements.length; i++) {
            Monitor elemento = new Monitor(elements[i]);
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
