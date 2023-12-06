package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.ProductDAOImplement;
import com.mycompany.phone.selling.webite.constant.PhoneStoreConstant;
import com.mycompany.phone.selling.webite.model.Account;
import com.mycompany.phone.selling.webite.model.Product;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	// Thiết lập dữ liệu truyền cho JSP
        try {
            List<Product> listSamung = ProductDAOImplement.getInstance().findAllByBrandNameOrderBySoldDesc(PhoneStoreConstant.PRODUCT_BRAND_NAME_SAMSUNG, PhoneStoreConstant.LIMIT_PRODUCT_IN_BRAND_NAME);
            List<Product> listApple = ProductDAOImplement.getInstance().findAllByBrandNameOrderBySoldDesc(PhoneStoreConstant.PRODUCT_BRAND_NAME_APPLE, PhoneStoreConstant.LIMIT_PRODUCT_IN_BRAND_NAME);
            List<Product> listXiaomi = ProductDAOImplement.getInstance().findAllByBrandNameOrderBySoldDesc(PhoneStoreConstant.PRODUCT_BRAND_NAME_XIAOMI, PhoneStoreConstant.LIMIT_PRODUCT_IN_BRAND_NAME);
            List<Product> listOppo = ProductDAOImplement.getInstance().findAllByBrandNameOrderBySoldDesc(PhoneStoreConstant.PRODUCT_BRAND_NAME_OPPO, PhoneStoreConstant.LIMIT_PRODUCT_IN_BRAND_NAME);
            List<Product> listNokia = ProductDAOImplement.getInstance().findAllByBrandNameOrderBySoldDesc(PhoneStoreConstant.PRODUCT_BRAND_NAME_NOKIA, PhoneStoreConstant.LIMIT_PRODUCT_IN_BRAND_NAME);
            List<Product> listVivo = ProductDAOImplement.getInstance().findAllByBrandNameOrderBySoldDesc(PhoneStoreConstant.PRODUCT_BRAND_NAME_VIVO, PhoneStoreConstant.LIMIT_PRODUCT_IN_BRAND_NAME);
            request.setAttribute("listSamsung", listSamung);
            request.setAttribute("listApple", listApple);
            request.setAttribute("listXiaomi", listXiaomi);
            request.setAttribute("listOppo", listOppo);
            request.setAttribute("listNokia", listNokia);
            request.setAttribute("listVivo", listVivo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
        HttpSession session = request.getSession();
        Object total = session.getAttribute("totalPay");
        Object count = session.getAttribute("countProduct");
        if (total == null) {
            Double totalPay = 0D;
            session.setAttribute("totalPay", totalPay);   
        }
        if (count == null) {
            Integer countProduct = 0;
            session.setAttribute("countProduct", countProduct);
        }
        // Kiểm tra phân quyền cho phần chuyển trang
        Account checkRole = (Account) session.getAttribute("loggedAccount");
        if (checkRole != null && checkRole.getKind().equals(PhoneStoreConstant.ACCOUNT_KIND_ADMIN)) {
            response.sendRedirect(request.getContextPath() + "/manage-user");
            System.out.println("Account (" + checkRole.getEmail() + ") with Kind " + checkRole.getKind() + "- ADMIN");
        } else {
           // Trả về trang chủ
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
