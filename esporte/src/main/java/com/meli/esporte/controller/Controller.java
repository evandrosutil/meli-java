package com.meli.esporte.controller;

import com.meli.esporte.model.Person;
import com.meli.esporte.model.PersonDTO;
import com.meli.esporte.model.Sport;
import com.meli.esporte.service.PersonService;
import com.meli.esporte.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final SportService sportService;
    private final PersonService personService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports() {
        List<Sport> sports = sportService.findSports();
        return ResponseEntity.ok(sports);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        Sport sport = sportService.findSport(name);
        if (sport == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(sport.getLevel());
    }

    @PostMapping("/addSport")
    public ResponseEntity<Sport> addSport(@RequestBody Sport sport) {
        sportService.addSport(sport);
        return ResponseEntity.status(HttpStatus.CREATED).body(sport);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);

    }
    @GetMapping("/athletes")
    public ResponseEntity<List<PersonDTO>> getAthletes() {
        List<PersonDTO> athletes = personService.findPeople();
        return ResponseEntity.ok(athletes);
    }
}