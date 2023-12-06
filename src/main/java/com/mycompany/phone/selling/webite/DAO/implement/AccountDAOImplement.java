package com.mycompany.phone.selling.webite.DAO.implement;

import com.mycompany.phone.selling.webite.DAO.AccountDAO;
import com.mycompany.phone.selling.webite.config.JPAConfig;
import com.mycompany.phone.selling.webite.model.Account;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class AccountDAOImplement implements AccountDAO{
    private static AccountDAOImplement instance;
    private AccountDAOImplement(){}
    public static AccountDAOImplement getInstance() throws Exception {
        if (instance == null) {
            instance = new AccountDAOImplement();
        }
        return instance;
    }
    EntityManager manager = null;
    TypedQuery<Account> query = null;
    EntityTransaction transaction = null;

    @Override
    public void insert(Account account) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(account);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void update(Account account) {
        manager = JPAConfig.getEntityManager();
        transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(account);
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
            Account account = manager.find(Account.class, id);
            if (account == null) {
                throw new Exception("Account not found");
            }
            manager.remove(account);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            manager = JPAConfig.getEntityManager();
            Account account = manager.find(Account.class, id);
            return account;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Account> findAll() {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Account.findAll", Account.class);
        return query.getResultList();
    }
    
    @Override
    public List<Account> findAll(int page, int size) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Account.findAll", Account.class);
        query.setFirstResult(page*size);
        query.setMaxResults(size);
        return query.getResultList(); 
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        try {
            manager = JPAConfig.getEntityManager();
            query = manager.createNamedQuery("Account.findByEmail", Account.class);
            query.setParameter("email", email);
            Account account = query.getSingleResult();
            if (account != null) {
                duplicate = true;
            }
        } catch (NoResultException e) {
            duplicate = false;
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        Account account = null;
        try {
            manager = JPAConfig.getEntityManager();
            query = manager.createNamedQuery("Account.findByPhone", Account.class);
            query.setParameter("phone", phone);
            account = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
        }
        if (account != null) {
            duplicate = true;
        }
        return duplicate;
    }    

    @Override
    public List<Account> findAllByStatus(Integer status) {
        manager = JPAConfig.getEntityManager();
        query = manager.createNamedQuery("Account.findAllByStatus", Account.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public Account findByEmailAndPassword(String email, String password) {
        try {
            manager = JPAConfig.getEntityManager();
            query = manager.createNamedQuery("Account.findByEmailAndPassword", Account.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return (Account) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Account findByEmail(String email) {
        try {
            manager = JPAConfig.getEntityManager();
            query = manager.createNamedQuery("Account.findByEmail", Account.class);
            query.setParameter("email", email);
            return (Account) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }
}
