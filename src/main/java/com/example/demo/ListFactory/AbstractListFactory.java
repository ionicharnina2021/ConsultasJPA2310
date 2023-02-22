package com.example.demo.ListFactory;

import com.example.demo.modelo.ActividadGrupoMonitor;
import com.example.demo.modelo.Monitor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListFactory<T,S> {
    S[] elements=null;
    ArrayList<T> arrayList;

    public AbstractListFactory(S[] elements, ArrayList<T> arrayList) {
        this.elements = elements;
        this.arrayList = arrayList;
    }

    public AbstractListFactory(ArrayList<T> arrayList) {
        this(null,arrayList);
    }

    public List<T> getList(){
        for (int i = 0; i < elements.length; i++) {
            arrayList.add(getNextElement(i));
        }
        return arrayList;
    }

    protected  T getNextElement(int i){return null;};

    ;
}
