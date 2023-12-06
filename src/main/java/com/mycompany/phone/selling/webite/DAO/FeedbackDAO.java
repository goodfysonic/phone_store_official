package com.mycompany.phone.selling.webite.DAO;

import com.mycompany.phone.selling.webite.model.Feedback;
import java.util.List;

public interface FeedbackDAO {
    void insert(Feedback feedback);
    void deleteById(Integer id) throws Exception;
    List<Feedback> findAll();
    List<Feedback> findAll(int page, int size);
    List<Feedback> findByProductIdAndStatus(Integer productId, Integer status);
}
