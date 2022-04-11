package com.meli.esporte.repository;

import com.meli.esporte.model.Sport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SportRepository implements ApplicationRepository <Sport> {

    private final List<Sport> sports;

    @Override
    public void add(Sport sport) {
        if (!sports.contains(sport)) {
            sports.add(sport);
        }
    }

    @Override
    public List<Sport> read() {
        return sports;
    }

    @Override
    public Optional<Sport> find(String name) {
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst();
    }
}
