package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class Race {

    private Integer distance;
    private BigDecimal prizeUSD;
    private String name;
    private Integer maxVehicleNum;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public Race() {
    }

    public Race(Integer distance, BigDecimal prizeUSD, String name, Integer maxVehicleNum) {
        this.distance = distance;
        this.prizeUSD = prizeUSD;
        this.name = name;
        this.maxVehicleNum = maxVehicleNum;
    }

    public Race(Integer distance, BigDecimal prizeUSD, String name, Integer maxVehicleNum, ArrayList<Vehicle> vehicles) {
        this.distance = distance;
        this.prizeUSD = prizeUSD;
        this.name = name;
        this.maxVehicleNum = maxVehicleNum;
        this.vehicles = vehicles;
    }

    public Integer getDistance() {
        return distance;
    }

    public BigDecimal getPrizeUSD() {
        return prizeUSD;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxVehicleNum() {
        return maxVehicleNum;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addCar(Integer speed, Double acceleration, Double steeringAngle, String plate) {
        if (vehicles.size() < maxVehicleNum)
            vehicles.add(new Car(speed, acceleration, steeringAngle, plate));
        else System.out.println("Reached max number of participants");

    }

    public void addMoto(Integer speed, Double acceleration, Double steeringAngle, String plate) {
        if (vehicles.size() < maxVehicleNum)
            vehicles.add(new Moto(speed, acceleration, steeringAngle, plate));
        else System.out.println("Reached max number of participants");
    }

    public void deleteVehicle(Vehicle vehicle) {
        if (vehicles.remove(vehicle)) {
            System.out.println("Vehicle successfully removed.");
        }
    }

    public void deleteVehicleWithPlate(String plate) {
        vehicles.removeIf(vehicle -> vehicle.getPlate().equals(plate));
    }
}