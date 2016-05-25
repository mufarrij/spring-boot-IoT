package it.uliana.dto;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */
public class WeatherDetail {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherDetail that = (WeatherDetail) o;

        if (main != null ? !main.equals(that.main) : that.main != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = main != null ? main.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WeatherDetail{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    private String main;
    private String description;



    public String getDescription() {
        return description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
