package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.util.SoutError;

import java.util.HashMap;
import java.util.List;

public class AuthService<T> {
    private Class<T> clazz;

    public AuthService(Class<T> clazz)
    {
        this.clazz = clazz;
    }
    BaseDAOImpl<T> useDao = new BaseDAOImpl<>(clazz);

    public List<T> login(String email, String password)
    {
        try {
            String jpql = "select t from "+clazz.getSimpleName()+ " t where email = ?1 and password = ?2";
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);
            return useDao.customQuery(jpql, params);
        }catch (Exception e)
        {
            SoutError.print("blue", e.getMessage());
            return null;
        }
    }
}