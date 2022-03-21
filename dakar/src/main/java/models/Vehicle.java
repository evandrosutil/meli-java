package models;

public class Vehicle {
    private Integer speed;
    private Double acceleration;
    private Double steeringAngle;
    private String plate;
    private Integer weight;
    private Integer wheels;

    public Vehicle(Integer speed, Double acceleration, Double steeringAngle, String plate, Integer weight, Integer wheels) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.steeringAngle = steeringAngle;
        this.plate = plate;
        this.weight = weight;
        this.wheels = wheels;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public Double getSteeringAngle() {
        return steeringAngle;
    }

    public void setSteeringAngle(Double steeringAngle) {
        this.steeringAngle = steeringAngle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return String.format("speed: %d km/h | acceleration: %.2f km/s | steering angle: %.2fº | plate: %s",
                speed, acceleration, steeringAngle, plate);
    }

}