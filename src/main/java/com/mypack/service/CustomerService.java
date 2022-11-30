package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Customer;

public class CustomerService {
    BaseDAOImpl<Customer> useDao = new BaseDAOImpl<>(Customer.class);

}