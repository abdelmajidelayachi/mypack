package com.mypack.controller;

import com.mypack.entity.Product;
import com.mypack.service.ProductService;
import com.mypack.util.SoutError;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("customer")
@SessionScoped
public class CustomerController implements Serializable {

    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CustomerController()
    {
        //
    }

    public Product getProductByReference()
    {
        try {
            //
            return null;
        }catch (Exception e)
        {
            SoutError.print("red", e.getMessage());
            return null;
        }
    }

    public List<Product> getAllProductsCustomer()
    {
        try {
            ProductService productService = new ProductService();
//            System.out.println("reference : "+reference);
            return productService.getAllProductsCustomer(reference);
        }catch (Exception e)
        {
            SoutError.print("red","errorGetAllProductsCustomer : " + e.getMessage());
            return null;
        }
    }
}
