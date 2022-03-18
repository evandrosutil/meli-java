import lombok.Data;

import java.util.ArrayList;

@Data
public class GlobalTemperatures {
    private ArrayList<City> cities = new ArrayList<>();

    public ArrayList<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public String calcColdestCity() {
        // points to the first city to start
        City coldest = cities.get(0);
        for (City city:
             cities) {
            if (city.getLowestTemp() < coldest.getLowestTemp()) {
                coldest = city;
            }
        }
        return coldest.getName();
    }

    public String calcHottestCity() {
        // points to the first city to start
        City hottest = cities.get(0);
        for (City city:
                cities) {
            if (city.getHighestTemp() > hottest.getHighestTemp()) {
                hottest = city;
            }
        }
        return hottest.getName();
    }
}
