package com.mycompany.phone.selling.webite.DAO;

import com.mycompany.phone.selling.webite.model.Invoice;
import java.util.List;

public interface InvoiceDAO {
    void insert(Invoice invoice);
    void update(Invoice invoice);
    void deleteById(Integer id) throws Exception;
    Invoice findById(Integer id);
    List<Invoice> findAll();
    List<Invoice> findAllByAccountId(Integer accountId);
    Invoice findByShoppingCartId(Integer shoppingCartId);
    List<Invoice> findAllByStatus(Integer status);
}
