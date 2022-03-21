package models;

public class Moto extends Vehicle {

    public Moto(Integer speed, Double acceleration, Double steeringAngle, String plate) {
        super(speed, acceleration, steeringAngle, plate, 300, 2);
    }
}