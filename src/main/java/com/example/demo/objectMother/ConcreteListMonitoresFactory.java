package com.example.demo.objectMother;

import com.example.demo.modelo.Monitor;

import java.util.ArrayList;

public class ConcreteListMonitoresFactory extends AbstractListFactory<Monitor,String>{

    public ConcreteListMonitoresFactory(String[] elements) {
        super(elements,new ArrayList<Monitor>());
    }

    @Override
    protected Monitor getNextElement(int i) {
        return new Monitor(elements[i]);
    }
}
