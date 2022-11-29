package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.util.SoutError;

import java.util.HashMap;
import java.util.List;

public class AuthService<T> {
    protected Class<T> clazz;

    public AuthService(Class<T> clazz)
    {
        this.clazz = clazz;
    }
    BaseDAOImpl<T> useDao = new BaseDAOImpl<>(clazz);

    public T login(String email, String password)
    {
        try {
            String jpql = "select t from "+clazz.getSimpleName()+ " t where t.email = ?1 and t.password = ?2";
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);

            List<T> list = useDao.customQuery(jpql, params);
            return list.size() > 0 ? list.get(0) : null;
        }catch (Exception e)
        {
            SoutError.print("blue", e.getMessage());
            return null;
        }
    }
}