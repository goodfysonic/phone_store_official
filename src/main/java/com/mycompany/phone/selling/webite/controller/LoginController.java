package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.model.Account;
import com.mycompany.phone.selling.webite.DAO.implement.AccountDAOImplement;
import com.mycompany.phone.selling.webite.constant.ErrorMessage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Trả về login
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String url =  "home.jsp";
        String email = (String) request.getParameter("your_name");
        String password = (String) request.getParameter("your_pass");
        System.out.println(email);
        System.out.println(password);
        Account login = null;
        try {
            login = AccountDAOImplement.getInstance().findByEmailAndPassword(email.trim(), password.trim());
        } catch (Exception e) {
            System.out.println("System error: " + e);
        }
        // Kiểm tra lỗi đăng nhập nếu sai trả về lỗi errorMessage
        if (login == null) {
            request.setAttribute("errorMessage", ErrorMessage.LOGIN_ERROR_WRONG_EMAIL_OR_PASSWORD);
            url = "/login.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } else if (!login.getPassword().equals(password)) {
            request.setAttribute("errorMessage", ErrorMessage.LOGIN_ERROR_WRONG_EMAIL_OR_PASSWORD);
            url = "/login.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } else { // Nếu không có lỗi thì thêm tài khoản vào session và chuyển servlet home
            HttpSession session = request.getSession();
            session.setAttribute("loggedAccount", login);
            response.sendRedirect("home");
        }
    }
}
