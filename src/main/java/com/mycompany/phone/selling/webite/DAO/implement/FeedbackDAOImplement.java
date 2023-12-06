package com.mycompany.phone.selling.webite.DAO.implement;

import com.mycompany.phone.selling.webite.DAO.FeedbackDAO;
import com.mycompany.phone.selling.webite.config.JPAConfig;
import com.mycompany.phone.selling.webite.model.Feedback;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FeedbackDAOImplement implements FeedbackDAO{
    private static FeedbackDAOImplement instance;
    private FeedbackDAOImplement(){}
    public static FeedbackDAOImplement getInstance() throws Exception {
        if (instance == null) {
            instance = new FeedbackDAOImplement();
        }
        return instance;
    }
    EntityManager manager = null;
    TypedQuery<Feedback> query = null;
    EntityTransaction transaction = null;

    @Override
    public void insert(Feedback feedback) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(feedback);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            Feedback product = manager.find(Feedback.class, id);
            if (product == null) {
                throw new Exception("Feedback not found");
            }
            manager.remove(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Feedback> findAll() {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Feedback.findAll", Feedback.class);
        return query.getResultList();
    }

    @Override
    public List<Feedback> findAll(int page, int size) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Feedback.findAll", Feedback.class);
        query.setFirstResult(page*size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public List<Feedback> findByProductIdAndStatus(Integer productId, Integer status) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("ShoppingCart.findByProductIdAndStatus", Feedback.class);
        query.setParameter("productId", productId);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
