import models.Car;
import models.Race;
import models.Vehicle;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Race corrida = new Race(100, BigDecimal.valueOf(13000), "Corrida Maluca", 5);
        corrida.addCar(180, 2.38, 23.12, "CEL7A214");
        corrida.addCar(220, 5.42, 34.12, "BAL4B223");
        corrida.addMoto(250, 6.50, 46.13, "MOT0B455");
        corrida.addMoto(134, 2.11, 23.45, "PIZ5A777");
        corrida.addCar(100, 1.32, 31.23, "OPP4S555");

        //corrida.deleteVehicle(new Car(100, 1.32, 31.23, "OPP4S555"));
        corrida.deleteVehicleWithPlate("OPP4S555");
        corrida.addCar(290, 14.23, 56.23, "TOP5A000");

        System.out.println(corrida.getWinner().toString());
    }


}
