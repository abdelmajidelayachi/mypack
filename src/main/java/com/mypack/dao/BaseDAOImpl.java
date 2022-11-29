package com.mypack.dao;

import com.mypack.config.EntityManagerConfig;
import com.mypack.dao.interfaces.BaseDAO;
import com.mypack.util.SoutError;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked", "unused"})
public class BaseDAOImpl<T> implements BaseDAO<T> {


    final private Class<T> clazz;

    public BaseDAOImpl(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public boolean save(T obj) {
        System.out.println("-----------  1  -----------");
//        EntityManager em = EntityManagerConfig.getEntityManager();
        EntityManager em = EntityManagerConfig.getEntityManager();
        System.out.println("-----------  2  -----------");
        try {
            System.out.println("-----------  3  -----------");
            em.getTransaction().begin(); // begin transaction
            em.persist(obj); // add the entity object to the persistent context, so any further changes are tracked.
            em.getTransaction().commit(); // commit transaction
            System.out.println("-----------  4  -----------");
            return true;
        }catch (Exception e)
        {
            System.out.println("-----------  5  -----------");
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            System.out.println("-----------  6  -----------");
            return false;
        }finally {
            System.out.println("-----------  7  -----------");
            em.close(); // close entityManager
            System.out.println("-----------  8  -----------");
        }
    }

    @Override
    public boolean update(T obj) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
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
        }
    }

    @Override
    public T findById(int id) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            T obj = em.find(clazz, id); // T find(Class<T> entityClass, Object primaryKey) – Returns entity for the given primary key.
            em.getTransaction().commit(); // commit transaction
            return obj;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            T obj = findById(id);
            if(obj != null)
            {
                T a = em.merge(obj);
                em.remove(a); // The remove() to delete the particular record.
            }
            em.getTransaction().commit(); // commit transaction
            return true;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return false;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public List<T> getAll() {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            Query query = em.createQuery("select t from "+ clazz.getSimpleName() +" t");
            List<T> list = query.getResultList();

            em.getTransaction().commit(); // commit transaction
            return list;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public List<T> getAllWhere(String field, Object value) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            Query query = em.createQuery("select t from "+clazz.getSimpleName()+" t where "+ field + "= :value");
            query.setParameter("value", value);

            List<T> list = query.getResultList(); // get All records where "condition" ==> ( 'field | String' = 'value | object' )

            em.getTransaction().commit(); // commit transaction
            return list;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public List<T> customQuery(String jpql, Map<String, Object> params) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try{
            em.getTransaction().begin(); // begin transaction
            TypedQuery<T> query = em.createQuery(jpql,clazz);

            final int[] index = {params.size()};
            params.forEach((key, value)->{
                query.setParameter(index[0],value);
                index[0] -=1;
            });
            List<T> list = query.getResultList();
            em.getTransaction().commit(); // commit transaction
            return list;
        }catch (Exception e){
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }
    //    @Override
    //    public Object customNativeQuery(String sql, HashMap<String, Object> map) {
    //        EntityManager em = EntityManagerConfig.getEntityManager();
    //        em.getTransaction().begin(); // begin transaction
    //        try {
    //            Query query = em.createNativeQuery(sql);
    //            // select firstName, lastName from Manager where id_manager = ? or id_manager = ?
    //
    //            em.getTransaction().commit(); // commit transaction
    //            return true;
    //        }catch (Exception e)
    //        {
    //            em.getTransaction().rollback(); // rollback transaction
    //            SoutError.print("yellow", e.getMessage());
    //            return null;
    //        }finally {
    //            em.close(); // close entityManager
    //            EntityManagerConfig.getEntityManagerFactory().close(); // close entityManagerFactory
    //        }
    //    }
}