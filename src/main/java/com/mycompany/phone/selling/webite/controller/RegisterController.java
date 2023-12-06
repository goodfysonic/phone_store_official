package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.AccountDAOImplement;
import com.mycompany.phone.selling.webite.constant.ErrorMessage;
import com.mycompany.phone.selling.webite.constant.PhoneStoreConstant;
import com.mycompany.phone.selling.webite.model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Trả về login
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String fullName = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("pass");
        System.out.println(email);
        System.out.println(fullName);
        System.out.println(password);
        Account newAccount = new Account();
        newAccount.setFullName(fullName.trim());
        newAccount.setEmail(email.trim());
        newAccount.setPassword(password.trim());
        newAccount.setKind(PhoneStoreConstant.ACCOUNT_KIND_USER);
        newAccount.setStatus(PhoneStoreConstant.STATUS_ACTIVE);
        try {
            if (AccountDAOImplement.getInstance().checkExistEmail(email)) {
                System.out.println(ErrorMessage.REGISTER_ERROR_EMAIL_EXISTED);
                request.setAttribute("errorMessage", ErrorMessage.REGISTER_ERROR_EMAIL_EXISTED);
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
            } else {
                AccountDAOImplement.getInstance().insert(newAccount);
                request.setAttribute("message", "Successfully");
                response.sendRedirect(request.getContextPath() + "/login");
                System.out.println("Successfully");
            }
        } catch (Exception e) {
            System.out.println("System error: " + e);
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
    }
}
