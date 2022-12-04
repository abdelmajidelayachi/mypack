package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Customer;
import com.mypack.util.SoutError;

import java.util.List;

public class CustomerService {
    BaseDAOImpl<Customer> useDao = new BaseDAOImpl<>(Customer.class);

    // get customer_id by reference
    public int getCustomerId(String reference) {
        try {
            List<Customer> customers = useDao.getAllWhere("reference", reference);
            return Math.toIntExact(customers.get(0).getId());
        }catch (Exception e)
        {
            SoutError.print("orange", "errorGetCustomerId : " + e.getMessage());
            return -1;
        }
    }
}