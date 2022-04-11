package com.meli.esporte.service;

import com.meli.esporte.model.Person;
import com.meli.esporte.model.PersonDTO;
import com.meli.esporte.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repo;

    public void addPerson(Person person) {
        repo.add(person);
    }

    public List<PersonDTO> findPeople() {
        List<Person> people = repo.read();
        return people.stream()
                .map(a-> new PersonDTO().modelToDTO(a))
                .collect(Collectors.toList());
    }

    public PersonDTO findPerson(String name) {
        Optional<Person> optionalPerson = repo.find(name);

        if (optionalPerson.isEmpty()) {
            return null;
        }
        return new PersonDTO().modelToDTO(optionalPerson.get());
    }
}
