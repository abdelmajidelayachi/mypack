package com.mypack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle", catalog = "mypack")
public class Vehicle {

    /*
   INSERT INTO `vehicle` (`id_vehicle`, `type`, `driver_id`) VALUES
    * */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vehicle")
    private Integer idVehicle;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "driver_id", insertable = false,updatable = false)
    private Integer driverId;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

}
