package com.mycompany.phone.selling.webite.DAO;

import com.mycompany.phone.selling.webite.model.Product;
import java.util.List;

public interface ProductDAO {
    void insert(Product product);
    void update(Product product);
    void deleteById(Integer id) throws Exception;
    Product findById(Integer id);
    List<Product> findAll();
    List<Product> findAll(int page, int size, String find);
    List<Product> findAll(String find);
    List<Product> findAllByStatus(Integer status);
    List<Product> findAllByBrandName(String brandName);
    List<Product> findAllByCapacity(String capacity);
    List<Product> findAllByBrandNameOrderBySoldDesc(String brandName, Integer limit);
}
