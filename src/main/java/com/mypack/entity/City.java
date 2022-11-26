package com.mypack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city", catalog = "mypack")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_city")
    private Integer idCity;

    @Basic
    @Column(name = "city_name")
    private String cityName;

    @Basic
    @Column(name = "postal_code")
    private Integer postalCode;

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getPostalCode () {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}