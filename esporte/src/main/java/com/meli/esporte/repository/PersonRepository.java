package com.meli.esporte.repository;

import com.meli.esporte.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PersonRepository implements ApplicationRepository<Person> {

    private final List<Person> people;

    @Override
    public void add(Person person) {
        if (!people.contains(person)) {
            people.add(person);
        } else System.out.println("Pessoa já consta na base.");
    }

    @Override
    public List<Person> read() {
        return people;
    }

    @Override
    public Optional<Person> find(String name) {
        for (Person person:
             people) {
            if (person.getFirstName().equals(name)) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }
}
