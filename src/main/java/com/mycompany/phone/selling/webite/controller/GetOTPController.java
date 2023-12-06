package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.AccountDAOImplement;
import com.mycompany.phone.selling.webite.service.EmailService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "GetOTPController", urlPatterns = {"/getOTP"})
public class GetOTPController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Trả về trang forgot password
        request.getRequestDispatcher("fpassword.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Lấy email forgot password từ form
        String email = request.getParameter("email");
        String message;
        String url;
        HttpSession session = request.getSession();
        boolean isEmailExisted = false;
        try {
            // Kiểm tra email có tồn tại hay không?
            if (AccountDAOImplement.getInstance().checkExistEmail(email)) {
                isEmailExisted = true;
            }
        } catch (Exception e) {
            System.out.println("System error: " + e);
        }
        if (isEmailExisted) { // Nếu tồn tại
            // Gửi email
            EmailService.sendMail(email);
            // Lưu email đã nhập và otp vừa gửi đi vào session
            session.setAttribute("emailForgot", email);
            session.setAttribute("otpForgot", EmailService.otpCode);
            url = "otpcheck.jsp";
            System.out.println("Forgot password with email (" + email + ")");
            // Chuyển đến trang otpcheck.jsp
            request.getRequestDispatcher(url).forward(request, response);
        } else { //  Nếu không tồn tại thì
            message = "Email has not been registered";
            // Chuyển lại trang hiện tại và trả về message lỗi
            request.setAttribute("message", message);
            request.getRequestDispatcher("fpassword.jsp").forward(request, response);
        }
    }
}
