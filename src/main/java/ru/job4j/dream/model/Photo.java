package ru.job4j.dream.model;

import java.util.Objects;

/**
 * ru.job4j.dream.model
 *
 * @author romanvohmin
 * @since 03.08.2020
 */
public class Photo {
    private int id;
    private String name;

    public Photo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Photo photo = (Photo) o;
        return getId() == photo.getId() && getName().equals(photo.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
