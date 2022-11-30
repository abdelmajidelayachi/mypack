package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Product;
import com.mypack.util.SoutError;

import java.util.List;

public class ProductService {
    BaseDAOImpl<Product> useDao = new BaseDAOImpl<>(Product.class);

    public List<Product> getAllProductsCustomer(int customer_id) {
        try {
            return useDao.getAllWhere("customer_id", customer_id);
        }catch (Exception e)
        {
            SoutError.print("orange", e.getMessage());
            return null;
        }
    }

    public Product getProductByTrackingId(int reference) {
        try {
            List<Product> products = useDao.getAllWhere("reference", reference);
            return products.get(0);
        } catch (Exception e) {
            SoutError.print("orange", e.getMessage());
            return null;
        }
    }
}