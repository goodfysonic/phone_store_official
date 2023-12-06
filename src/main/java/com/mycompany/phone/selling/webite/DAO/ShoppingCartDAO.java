package com.mycompany.phone.selling.webite.DAO;

import com.mycompany.phone.selling.webite.model.ShoppingCart;

public interface ShoppingCartDAO {
    void insert(ShoppingCart shoppingCart);
    ShoppingCart findById(Integer id);
    ShoppingCart findByAccountIdAndStatus(Integer accountId, Integer status);
    void update(ShoppingCart shoppingCart);
}
