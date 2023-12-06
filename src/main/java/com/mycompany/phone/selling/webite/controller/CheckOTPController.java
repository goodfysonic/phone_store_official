package com.mycompany.phone.selling.webite.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CheckOTPController", urlPatterns = {"/check-otp"})
public class CheckOTPController extends HttpServlet {
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
        HttpSession session = request.getSession();
        Integer otpForgot = (Integer) session.getAttribute("otpForgot");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String number3 = request.getParameter("number3");
        String number4 = request.getParameter("number4");
        String number5 = request.getParameter("number5");
        String number6 = request.getParameter("number6");
        // Ghép chuỗi sau đó ép kiểu sang Integer để kiểm tra otp có trùng khớp
        Integer otpSubmit = Integer.valueOf(number1 + number2 + number3 + number4 + number5 + number6);
        System.out.println("Check " + otpForgot + "-" + otpSubmit);
        if (otpForgot.equals(otpSubmit)) { // Trùng khớp thì chuyển trang đổi mật khẩu mới
            request.getRequestDispatcher("rpassword.jsp").forward(request, response);
        } else { // Nếu không thì trả về lỗi errorForgot            
            request.setAttribute("errorForgot", "Wrong OTP");
            request.getRequestDispatcher("otpcheck.jsp").forward(request, response);
        }
    }
}
