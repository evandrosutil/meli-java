package models;

import java.math.BigDecimal;

public class Vehicle {

    private String model;
    private String brand;
    private BigDecimal price;

    public Vehicle(String model, String brand, BigDecimal price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
