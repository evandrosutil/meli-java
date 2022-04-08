package com.meli.jewels.controller;

import com.meli.jewels.model.Jewel;
import com.meli.jewels.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PearlController {

    @Autowired
    private JewelService jewelServ;

    @PostMapping("/joia/inserir")
    public ResponseEntity<?> createJewel(@RequestBody Jewel jewel) {
        UUID jewelID = jewelServ.saveJewel(jewel);

        return ResponseEntity.status(HttpStatus.CREATED).body("joia ".concat(jewelID.toString()).concat(" criada."));
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Jewel>> listJewels() {
        return ResponseEntity.ok(jewelServ.getJewels());
    }

    @DeleteMapping("/joia/excluir")
    public ResponseEntity<String> deleteJewel(@RequestParam String numero_identificacao) {
        jewelServ.deleteJewel(UUID.fromString(numero_identificacao));
        return ResponseEntity.ok(String.format("Joia %s deletada com sucesso", numero_identificacao));
    }

    @PutMapping("joia/atualizar")
    public ResponseEntity<Jewel> updateJewel(
            @RequestParam UUID numero_identificacao,
            @RequestParam String material,
            @RequestParam Double weigth,
            @RequestParam Integer carats) {
        Jewel jewel = jewelServ.findJewel(numero_identificacao);
        if (jewel == null) {
            return ResponseEntity.notFound().build();
        }

        jewel.setCarats(carats);
        jewel.setMaterial(material);
        jewel.setWeight(weigth);
        jewelServ.saveJewel(jewel);

        return ResponseEntity.status(HttpStatus.OK).body(jewel);
    }
}