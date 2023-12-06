package com.mycompany.phone.selling.webite.DAO.implement;

import com.mycompany.phone.selling.webite.DAO.CartItemDAO;
import com.mycompany.phone.selling.webite.config.JPAConfig;
import com.mycompany.phone.selling.webite.model.CartItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
// import jakarta.persistence.TypedQuery;

public class CartItemDAOImplement implements CartItemDAO{
    private static CartItemDAOImplement instance;
    private CartItemDAOImplement(){}
    public static CartItemDAOImplement getInstance() throws Exception {
        if (instance == null) {
            instance = new CartItemDAOImplement();
        }
        return instance;
    }
    EntityManager manager = null;
    // TypedQuery<CartItem> query = null;
    EntityTransaction transaction = null;

    @Override
    public void insert(CartItem item) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(item);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void edit(CartItem item) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(item);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }
}
