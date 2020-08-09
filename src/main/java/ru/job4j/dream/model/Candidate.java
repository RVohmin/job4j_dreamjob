package ru.job4j.dream.model;

import java.util.Objects;

/**
 * ru.job4j.dream.model
 *
 * @author romanvohmin
 * @since 29.07.2020
 */
public class Candidate {
    private int id;
    private String name;
    private Integer photoId;
    private Integer cityId;

    public Candidate(int id, String name, Integer photoId, Integer cityId) {
        this.id = id;
        this.name = name;
        this.photoId = photoId;
        this.cityId = cityId;
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

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
