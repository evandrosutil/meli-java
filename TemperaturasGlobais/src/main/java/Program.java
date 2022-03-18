public class Program {

    public static void main(String[] args) {
        GlobalTemperatures temperaturas = new GlobalTemperatures();

        temperaturas.addCity(new City("Londres", -2, 33));
        temperaturas.addCity(new City("Madrid", -3, 32));
        temperaturas.addCity(new City("Nueva York", -8, 27));
        temperaturas.addCity(new City("Buenos Aires", 4, 37));
        temperaturas.addCity(new City("Asunción", 6, 42));
        temperaturas.addCity(new City("São Paulo", 5, 43));
        temperaturas.addCity(new City("Lima", 0, 39));
        temperaturas.addCity(new City("Santiago de Chile", -7, 26));
        temperaturas.addCity(new City("Lisboa", -1, 31));
        temperaturas.addCity(new City("Tokio", -10, 35));

        String coldest = temperaturas.calcColdestCity();
        String hottest = temperaturas.calcHottestCity();

        System.out.printf("A cidade com temperatura mais alta é %s\n", hottest);
        System.out.printf("A cidade com temperatura mais baixa é %s\n", coldest);
    }
}
