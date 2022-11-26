package com.mypack.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product", catalog = "mypack")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private Long id;
    @Basic
    @Column(name = "reference")
    private String reference;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "weight")
    private Double weight;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "customer_id")
    private Long customer_id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
