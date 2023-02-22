package com.example.demo.objectMother;

import com.example.demo.modelo.Cabana;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteListCabanaFactory implements AbstractListFactory<Cabana>{
    String elements[] ;
    ArrayList<Cabana> arrayList = new ArrayList<>();

    public ConcreteListCabanaFactory(String[] elements) {
        this.elements = elements;
    }

    @Override
    public List<Cabana> getList() {
        for (int i = 0; i < elements.length; i++) {
            Cabana cabana = new Cabana(elements[i], new Random().nextBoolean());
            arrayList.add(cabana);
        }
        return arrayList;
    }
}
