package com.meli.esporte.model;

import lombok.Data;

@Data
public class PersonDTO {

    private String firstName;
    private String lastName;
    private String sportName;

    public PersonDTO modelToDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setSportName(person.getSport());

        return personDTO;
    }

}
