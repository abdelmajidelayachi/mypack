package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Product;
import com.mypack.util.SoutError;

import java.util.List;

public class ProductService {
    BaseDAOImpl<Product> useDao = new BaseDAOImpl<>(Product.class);

    public List<Product> getAllProductsCustomer(String reference) {
        CustomerService customerService = new CustomerService();
        int customer_id = customerService.getCustomerId(reference);
        try {
            return useDao.getAllWhere("customer_id", customer_id);
        }catch (Exception e)
        {
            SoutError.print("orange", "errorGetAllProductsCustomer : " + e.getMessage());
            return null;
        }
    }

    public List<Product> getProductByReference(String reference) {
        try {
            return useDao.getAllWhere("reference", reference);
        } catch (Exception e) {
            SoutError.print("orange","errrorGetProductByTrackingId : " + e.getMessage());
            return null;
        }
    }

    public boolean updateProductDelivery(int product_id) {
        try {
            System.out.println("product_id: " + product_id);
            Product product = useDao.findById(product_id);
            System.out.println(product.getId());
            System.out.println(product.getCustomer_id());
            product.setStatus("delivered");
            useDao.update(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            SoutError.print("orange", e.getMessage());
            return false;
        }
    }
}