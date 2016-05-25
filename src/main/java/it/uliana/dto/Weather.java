package it.uliana.dto;

import java.util.List;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */
public class Weather {

    private String name;

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", weather=" + weather +
                '}';
    }

    private List<WeatherDetail> weather;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather1 = (Weather) o;

        if (name != null ? !name.equals(weather1.name) : weather1.name != null) return false;
        return weather != null ? weather.equals(weather1.weather) : weather1.weather == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        return result;
    }



    public String getName() {
        return name;
    }

    public List<WeatherDetail> getWeather() {
        return weather;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeather(List<WeatherDetail> weather) {
        this.weather = weather;
    }
}
