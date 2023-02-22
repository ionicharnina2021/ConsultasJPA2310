package com.example.demo.objectMother;

import com.example.demo.modelo.Monitor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListFactory<T,S> {
    S[] elements;
    ArrayList<T> arrayList;

    public AbstractListFactory(S[] elements, ArrayList<T> arrayList) {
        this.elements = elements;
        this.arrayList = arrayList;
    }

    public List<T> getList(){
        for (int i = 0; i < elements.length; i++) {
            arrayList.add(getNextElement(i));
        }
        return arrayList;
    }

    protected abstract T getNextElement(int i);

    ;
}
