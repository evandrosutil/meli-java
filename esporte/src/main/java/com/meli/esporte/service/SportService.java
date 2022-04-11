package com.meli.esporte.service;

import com.meli.esporte.model.Sport;
import com.meli.esporte.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SportService {

    private final SportRepository repo;

    public void addSport(Sport sport) {
        repo.add(sport);
    }

    public List<Sport> findSports() {
        return repo.read();
    }

    public Sport findSport(String name) {
        Optional<Sport> optionalSport = repo.find(name);

        if (optionalSport.isEmpty()) {
            return null;
        }
        return optionalSport.get();
    }
}
