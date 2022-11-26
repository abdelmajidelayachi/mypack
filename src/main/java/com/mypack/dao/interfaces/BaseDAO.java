package com.mypack.dao.interfaces;

import java.util.List;

public interface BaseDAO<T> {
    public boolean save(T obj);
    public boolean update(T obj);
    public T findById(int id);
    public boolean delete(int id);
    public List<T> getAll();
    public List<T> getAllWhere(String field, Object value);
    


}