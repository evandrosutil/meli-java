package models;

import java.util.ArrayList;

public class Garage {
    private int id;
    private ArrayList<Vehicle> vehicles;

    public Garage(int id, ArrayList<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public double calcAvg() {
        double priceAvg = vehicles
                .stream()
                .mapToDouble(Vehicle -> Vehicle.getPrice().doubleValue())
                .summaryStatistics()
                .getAverage();

        return priceAvg;
    }

}
