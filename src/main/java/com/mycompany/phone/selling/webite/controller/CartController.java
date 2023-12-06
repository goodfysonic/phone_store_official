package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.model.Account;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Thiết lập dữ liệu truyền cho JSP
        // Chưa đăng nhập thì chuyển sang trang đăng nhập mới có thể vào trang giỏ hàng
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("loggedAccount");
        if (account == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            // Trả về trang chủ
            RequestDispatcher rq = request.getRequestDispatcher("cart.jsp");// /test/index.jsp");
            rq.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
