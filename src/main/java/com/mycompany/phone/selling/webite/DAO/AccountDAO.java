package com.mycompany.phone.selling.webite.DAO;

import com.mycompany.phone.selling.webite.model.Account;
import java.util.List;

public interface AccountDAO {
    void insert(Account account);
    void update(Account account);
    void deleteById(Integer id) throws Exception;
    Account findById(Integer id);
    Account findByEmailAndPassword(String email, String password);
    List<Account> findAll();
    List<Account> findAll(int page, int size);
    List<Account> findAllByStatus(Integer status);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
    Account findByEmail(String email);
}
