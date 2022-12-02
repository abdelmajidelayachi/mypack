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

    public List<Product> getProductProductsByReference()
    {
        try {
            ProductService productService = new ProductService();
            if(reference.contains("U-"))
            {
                return productService.getAllProductsCustomer(reference);
            }else{
                return productService.getProductByReference(reference);
            }
        }catch (Exception e)
        {
            SoutError.print("red","errorGetAllProductsCustomer : " + e.getMessage());
            return null;
        }
    }
}