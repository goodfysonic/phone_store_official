package com.mycompany.phone.selling.webite.DAO.implement;

import com.mycompany.phone.selling.webite.DAO.ShoppingCartDAO;
import com.mycompany.phone.selling.webite.config.JPAConfig;
import com.mycompany.phone.selling.webite.model.ShoppingCart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ShoppingCartDAOImplement implements ShoppingCartDAO{
    private static ShoppingCartDAOImplement instance;
    private ShoppingCartDAOImplement(){}
    public static ShoppingCartDAOImplement getInstance() throws Exception {
        if (instance == null) {
            instance = new ShoppingCartDAOImplement();
        }
        return instance;
    }
    EntityManager manager = null;
    TypedQuery<ShoppingCart> query = null;
    EntityTransaction transaction = null;
    
    @Override
    public void insert(ShoppingCart shoppingCart) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public ShoppingCart findById(Integer id) {
        try {
            manager = JPAConfig.getEntityManager();
            ShoppingCart shoppingCart = manager.find(ShoppingCart.class, id);
            return shoppingCart;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ShoppingCart findByAccountIdAndStatus(Integer accountId, Integer status) {
        try {
            manager = JPAConfig.getEntityManager();
            query = manager.createNamedQuery("ShoppingCart.findByAccountIdAndStatus", ShoppingCart.class);
            query.setParameter("accountId", accountId);
            query.setParameter("status", status);
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }
}
