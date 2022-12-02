package com.mypack.controller;

import com.mypack.entity.Driver;
import com.mypack.entity.Product;
import com.mypack.service.ProductService;
import com.mypack.util.SoutError;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named("driverController")
@ManagedBean
@ViewScoped
public class DriverController implements Serializable {
    FacesContext context = FacesContext.getCurrentInstance();
    private List<Product> products;

    /**
     * @return the products of the driver
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * take the driver from the session and get his products
     */
    @PostConstruct
    public void init() {
        Driver driver = (Driver) context.getExternalContext().getSessionMap().get("getUser");
        int driver_id = driver.getId_driver();
        products = new ProductService().getAllProductsCustomer(driver_id);
    }

    public String productDelivery(int product_id) throws IOException {
        SoutError.print("red","id product: " + product_id);
        boolean idUpdated = new ProductService().updateProductDelivery(product_id);

        SoutError.print("blue","idUpdated: " + idUpdated);
        return "driver/welcome?faces-redirect=true";

    }

}
