package com.meli.jewels.service;

import com.meli.jewels.model.Jewel;
import com.meli.jewels.repository.JewelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class JewelService {

    private final JewelRepository jewelRepo;

    public JewelService(JewelRepository jewelRepo) {
        this.jewelRepo = jewelRepo;
    }

    @Transactional(readOnly = true)
    public List<Jewel> getJewels() {
        return jewelRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Jewel findJewel(UUID id) {
        return jewelRepo.findById(id).orElse(null);
    }

    @Transactional
    public UUID saveJewel(Jewel jewel) {
        Jewel savedJewel = jewelRepo.save(jewel);
        return savedJewel.getId();
    }

    @Transactional
    public void deleteJewel(UUID id) {
        jewelRepo.deleteById(id);
    }
}
