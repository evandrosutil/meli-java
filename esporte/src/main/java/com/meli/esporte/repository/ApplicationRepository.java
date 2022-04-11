package com.meli.esporte.repository;

import com.meli.esporte.model.Person;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository <T> {

    void add(T obj);
    List<T> read();
    Optional<T> find(String name);
}
