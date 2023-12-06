package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.AccountDAOImplement;
import com.mycompany.phone.selling.webite.model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ProfileController", urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String avatar = request.getParameter("avatar");
        if (phone.trim().length() == 0) {
            phone = null;
        }
        if (address.trim().length() == 0) {
            address = null;
        }
        if (avatar.trim().length() == 0) {
            avatar = null;
        }
        HttpSession session = request.getSession();
        // Cập nhật trên tài khoản hiện tại của session
        Account updateProfile = (Account) session.getAttribute("loggedAccount"); // Lấy tài khoản từ session - phải đăng nhập trước đó
        updateProfile.setFullName(fullName);
        updateProfile.setPhone(phone);
        updateProfile.setAddress(address);
        updateProfile.setAvatar(avatar);
        // Cập nhật dưới database
        try {
            AccountDAOImplement.getInstance().update(updateProfile);
        } catch (Exception e) {
            System.out.println("System error: " + e);
        }
        // Chuyển lại trang profile
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
