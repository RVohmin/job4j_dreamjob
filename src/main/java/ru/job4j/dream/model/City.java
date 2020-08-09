package ru.job4j.dream.model;

import java.util.Objects;

/**
 * ru.job4j.dream.model
 *
 * @author romanvohmin
 * @since 08.08.2020
 */
public class City {
    int id;
    String city;

    public City(int id, String city) {
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city1 = (City) o;
        return getId() == city1.getId() && Objects.equals(getCity(), city1.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity());
    }
}
