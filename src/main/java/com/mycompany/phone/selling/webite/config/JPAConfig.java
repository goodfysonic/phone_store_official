package com.mycompany.phone.selling.webite.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PhoneStore");
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static void close() {
        emf.close();
    }
}
