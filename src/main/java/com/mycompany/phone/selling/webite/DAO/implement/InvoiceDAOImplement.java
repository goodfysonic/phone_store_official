package com.mycompany.phone.selling.webite.DAO.implement;

import com.mycompany.phone.selling.webite.DAO.InvoiceDAO;
import com.mycompany.phone.selling.webite.config.JPAConfig;
import com.mycompany.phone.selling.webite.model.Invoice;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class InvoiceDAOImplement implements InvoiceDAO {
    private static InvoiceDAOImplement instance;
    private InvoiceDAOImplement(){}
    public static InvoiceDAOImplement getInstance() throws Exception {
        if (instance == null) {
            instance = new InvoiceDAOImplement();
        }
        return instance;
    }
    EntityManager manager = null;
    TypedQuery<Invoice> query = null;
    EntityTransaction transaction = null;
    
    @Override
    public void insert(Invoice invoice) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(invoice);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void update(Invoice invoice) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(invoice);
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
            Invoice invoice = manager.find(Invoice.class, id);
            if (invoice == null) {
                throw new Exception("Invoice not found");
            }
            manager.remove(invoice);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public Invoice findById(Integer id) {
        try {
            manager = JPAConfig.getEntityManager();
            Invoice invoice = manager.find(Invoice.class, id);
            return invoice;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Invoice> findAll() {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Invoice.findAll", Invoice.class);
        return query.getResultList();
    }

    @Override
    public List<Invoice> findAllByAccountId(Integer accountId) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Invoice.findAllByAccountId", Invoice.class);
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }

    @Override
    public Invoice findByShoppingCartId(Integer shoppingCartId) {
        try {
            manager = JPAConfig.getEntityManager();
            query = manager.createNamedQuery("Invoice.findByShoppingCartId", Invoice.class);
            query.setParameter("shoppingCartId", shoppingCartId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Invoice> findAllByStatus(Integer status) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Invoice.findAllByStatus", Invoice.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
    
}
