package com.mypack.dao.interfaces;

import com.mypack.config.EntityManagerConfig;
import com.mypack.util.SoutError;
import jakarta.persistence.EntityManager;

public class BaseDAOImpl<T> implements BaseDAO<T>{

    public static EntityManager em = EntityManagerConfig.getEntityManager();

    private Class<T> clazz;

    public BaseDAOImpl(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public boolean save(T obj) {
        em.getTransaction().begin(); // begin transaction
        try {
            em.persist(obj); // add the entity object to the persistent context, so any further changes are tracked.
            em.getTransaction().commit(); // commit transaction
            return true;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return false;
        }finally {
            em.close(); // close entityManager
            EntityManagerConfig.getEntityManagerFactory().close(); // close entityManagerFactory
        }
    }

    @Override
    public boolean update(T obj) {
        em.getTransaction().begin(); // begin transaction
        try {
            em.merge(obj); // The main intention of the merge method is to update a persistent entity instance with new field values from a detached entity instance.
            em.getTransaction().commit(); // commit transaction
            return true;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return false;
        }finally {
            em.close(); // close entityManager
            EntityManagerConfig.getEntityManagerFactory().close(); // close entityManagerFactory
        }
    }
}