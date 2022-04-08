package com.meli.jewels.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Jewel {
    @Id
    @GeneratedValue()
    private UUID id;
    private String material;
    private Double weight;
    private Integer carats;

    @Override
    public String toString() {
        return String.format("%s - %.2f kg - %d quilates", material, weight, carats);
    }
}
