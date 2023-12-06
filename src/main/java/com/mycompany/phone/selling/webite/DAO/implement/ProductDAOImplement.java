package com.mycompany.phone.selling.webite.DAO.implement;

import com.mycompany.phone.selling.webite.DAO.ProductDAO;
import com.mycompany.phone.selling.webite.config.JPAConfig;
import com.mycompany.phone.selling.webite.model.Product;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ProductDAOImplement implements ProductDAO{
    private static ProductDAOImplement instance;
    private ProductDAOImplement(){}
    public static ProductDAOImplement getInstance() throws Exception {
        if (instance == null) {
            instance = new ProductDAOImplement();
        }
        return instance;
    }
    EntityManager manager = null;
    TypedQuery<Product> query = null;
    EntityTransaction transaction = null;

    @Override
    public void insert(Product product) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void update(Product product) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(product);
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
            Product product = manager.find(Product.class, id);
            if (product == null) {
                throw new Exception("Product not found");
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
    public Product findById(Integer id) {
        manager = JPAConfig.getEntityManager();
        Product product = manager.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.getAll", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> findAll(int page, int size, String find) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.findAll", Product.class);
        query.setParameter("title", "%" + find + "%");
        query.setFirstResult(page*size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByStatus(Integer status) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.findAllByStatus", Product.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByBrandName(String brandName) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.findAllByBrandName", Product.class);
        query.setParameter("brandName", brandName);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByCapacity(String capacity) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.findAllByCapacity", Product.class);
        query.setParameter("capacity", capacity);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByBrandNameOrderBySoldDesc(String brandName, Integer limit) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.findAllByBrandNameOrderBySoldDesc", Product.class);
        query.setParameter("brandName", brandName);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<Product> findAll(String find) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Product.findAll", Product.class);
        query.setParameter("title", "%" + find + "%");
        return query.getResultList();
    }
}
