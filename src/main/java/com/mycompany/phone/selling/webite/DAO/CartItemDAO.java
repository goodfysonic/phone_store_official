package com.mycompany.phone.selling.webite.DAO;

import com.mycompany.phone.selling.webite.model.CartItem;

public interface CartItemDAO {
    void insert(CartItem item);
    void edit(CartItem item);
}
