package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.AccountDAOImplement;
import com.mycompany.phone.selling.webite.model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "ManageUserController", urlPatterns = {"/manage-user"})
public class ManageUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        try {
            List<Account> listUser = AccountDAOImplement.getInstance().findAll();
            request.setAttribute("listUser", listUser);
        } catch (Exception e) {
            System.out.println("System error manage user");
        }
        // Trả về trang quản lý người dùng
	request.getRequestDispatcher("manage_user.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        Integer idUser = Integer.valueOf(request.getParameter("idUser"));
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        if (phone.trim().length() == 0) {
            phone = null;
        }
        if (address.trim().length() == 0) {
            address = null;
        }
        // Truy xuất và cập nhật dưới database
        try {
            Account updateAccount = AccountDAOImplement.getInstance().findById(idUser);
            updateAccount.setFullName(fullName);
            updateAccount.setAddress(address);
            updateAccount.setPhone(phone);
            AccountDAOImplement.getInstance().update(updateAccount);
        } catch (Exception e) {
            System.out.println("System error: " + e);
        }
        System.out.println("Update successfully");
        request.getRequestDispatcher("manage_user.jsp").forward(request, response);
    }
}
