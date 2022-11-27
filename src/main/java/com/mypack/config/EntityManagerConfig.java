package com.mypack.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {
    public static EntityManagerFactory emf = null;

    public static EntityManagerFactory getEntityManagerFactory()
    {
        if(emf == null)
        {
            emf = Persistence.createEntityManagerFactory("default");
            return emf;
        }
        return emf;
    }

    public static EntityManager getEntityManager()
    {
        return getEntityManagerFactory().createEntityManager();
    }
}