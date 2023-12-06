package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.model.CartItem;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

@WebServlet(name = "RemoveCartItemController", urlPatterns = {"/remove-cart-item"})
public class RemoveCartItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String itemKey = request.getParameter("itemKey");
        HttpSession session = request.getSession();
        Object object = session.getAttribute("cart");
        Map<String, CartItem> map = (Map<String, CartItem>) object;
        CartItem cartItem = map.get(itemKey);
        Double totalPay = (Double) session.getAttribute("totalPay");
        session.setAttribute("totalPay", totalPay - cartItem.getQuantity() * cartItem.getProductId().getPrice());
        Integer count = (Integer )session.getAttribute("countProduct");
        session.setAttribute("countProduct", count - cartItem.getQuantity());
        map.remove(itemKey);
        session.setAttribute("cart", map);
        System.out.println("Remove CartItem with Product (" + cartItem.getProductId().getId() + ")");
        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
