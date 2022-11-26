package com.mypack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "driver", catalog = "mypack")
public class Driver {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_driver")
    private Integer id_driver;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "center_id")
    private Integer center_id;

    @ManyToOne
    @JoinColumn(name = "center_id", referencedColumnName = "id_center")
    private Center center;

    public Integer getId_driver() {
        return id_driver;
    }

    public void setId(Integer id_driver) {
        this.id_driver = id_driver;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCenter_id() {
        return center_id;
    }

    public void setCenter_id(Integer center_id) {
        this.center_id = center_id;
    }
}