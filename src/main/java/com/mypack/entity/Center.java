package com.mypack.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "center", catalog = "mypack")
public class Center {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_center")
    private Integer idCenter;

    @Basic
    @Column(name = "center_name")
    private String centerName;

    @Basic
    @Column(name = "city_id")
    private Integer cityId;

    @Basic
    @Column(name = "manager_id")
    private String managerId;

//    @OneToOne
//    @JoinColumn(name = "")
//    private

    @OneToMany(mappedBy = "center_id")
    private Set<Driver> drivers = new HashSet<>();

    public Integer getIdCenter() {
        return idCenter;
    }

    public void setIdCenter(Integer idCenter) {
        this.idCenter = idCenter;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
