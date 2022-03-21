import models.Garage;
import models.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Garage garage = new Garage(1, new ArrayList<>(
                List.of(
                        new Vehicle("Fiesta", "Ford", BigDecimal.valueOf(1000)),
                        new Vehicle("Focus", "Ford", BigDecimal.valueOf(1200)),
                        new Vehicle("Explorer", "Ford", BigDecimal.valueOf(2500)),
                        new Vehicle("Uno", "Fiat", BigDecimal.valueOf(500)),
                        new Vehicle("Cronos", "Fiat", BigDecimal.valueOf(1000)),
                        new Vehicle("Torino", "Fiat", BigDecimal.valueOf(1250)),
                        new Vehicle("Aveo", "Chevrolet", BigDecimal.valueOf(1250)),
                        new Vehicle("Spin", "Chevrolet", BigDecimal.valueOf(2500)),
                        new Vehicle("Corola", "Toyota",BigDecimal.valueOf(1200)),
                        new Vehicle("Fortuner", "Toyota",BigDecimal.valueOf(3000)),
                        new Vehicle("Logan", "Renault",BigDecimal.valueOf(950))
                )
            )
        );

        System.out.println(garage.getVehicles());
        System.out.println("\n\nSorting by price\n-------------");
        Object[] sortedGarage = garage.getVehicles()
                .stream()
                .sorted((vehicleY, vehicleX)->vehicleX.getPrice().compareTo(vehicleY.getPrice()))
                .toArray();

        Arrays.stream(sortedGarage).forEach(System.out::println);

        System.out.println("\n\nSorting by brand\n-------------");
        garage.getVehicles()
                .stream()
                .sorted((vehicleX, vehicleY)->vehicleX.getBrand().compareTo(vehicleY.getBrand()))
                .forEach(System.out::println);

        System.out.println("\n\nOnly vehicules with price below 1000\n-------------");
        garage.getVehicles()
                .stream().filter(vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(1000)) < 0)
                .forEach(System.out::println);

        System.out.println("\n\nOnly vehicules with price gte 1000\n-------------");
        garage.getVehicles()
                .stream().filter(vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(1000)) >= 0)
            .forEach(System.out::println);

        System.out.println("\n\nAvg price\n------------------");
        double priceAvg = garage.calcAvg();

        System.out.printf("R$ %.2f%n", priceAvg);
    }
}
