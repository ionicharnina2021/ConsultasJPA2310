package com.example.demo.utiles;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class OptionalListMapper<T> {
    public Optional<List<T>> map(Iterable<T> iterable){
        return Optional.of(StreamSupport.stream(iterable.spliterator(),false).toList());
    }
}
