package models;

public class Car extends Vehicle {

    public Car(Integer speed, Double acceleration, Double steeringAngle, String plate) {
        super(speed, acceleration, steeringAngle, plate, 1000, 4);
    }
}
