package com.mypack.dao.interfaces;

public interface BaseDAO<T> {
    public boolean save(T obj);
    public boolean update(T obj);

}