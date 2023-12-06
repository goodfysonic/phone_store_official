package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.AccountDAOImplement;
import com.mycompany.phone.selling.webite.service.EmailService;
import com.mycompany.phone.selling.webite.model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ChangeForgotPasswordController", urlPatterns = {"/change-forgot-password"})
public class ChangeForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer otpForgot = (Integer) session.getAttribute("otpForgot");
        String emailForgot = (String) session.getAttribute("emailForgot");
        String newPassword = request.getParameter("re_password");
        // Kiểm tra 1 lần nữa otp đúng và email có tồn tại sẽ cho thay đổi mật khẩu
        if (EmailService.otpCode.equals(otpForgot)) {
            try {
                Account check = AccountDAOImplement.getInstance().findByEmail(emailForgot);
                if (check == null) {
                    request.setAttribute("errorMessage", "This email doesn't exist!");
                } else {
                    check.setPassword(newPassword);
                    AccountDAOImplement.getInstance().update(check);
                }
            } catch (Exception e) {
                System.out.println("Change forgot password error!");
            }
            // Sau khi cập nhật hoàn thành thì xóa các biến trong session và chuyển trang login
            EmailService.otpCode = null;
            session.removeAttribute("otpForgot");
            session.removeAttribute("emailForgot");
            response.sendRedirect(request.getContextPath() + "/login");
        } else { // Nếu có lỗi xảy ra trả về errorMessage
            request.setAttribute("errorMessage", "Change password failure");
            request.getRequestDispatcher("rpassword.jsp").forward(request, response);
        }
    }
}
