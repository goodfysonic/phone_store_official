package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.ProductDAOImplement;
import com.mycompany.phone.selling.webite.model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "ManageProductController", urlPatterns = {"/manage-product"})
public class ManageProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        try {
            List<Product> listProduct = ProductDAOImplement.getInstance().findAll();
            request.setAttribute("listProduct", listProduct);
        } catch (Exception e) {
            System.out.println("System error manage product");
        }
        // Trả về trang chủ
	request.getRequestDispatcher("manage_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String brandName = request.getParameter("brandName");
        String capacity = request.getParameter("capacity");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String stock = request.getParameter("stock");
        String thumbnail = request.getParameter("thumbnail");
        String subImage1 = request.getParameter("subImage1");
        String subImage2 = request.getParameter("subImage2");
        String display = request.getParameter("display");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        Product product = new Product(title, brandName, capacity, display, color, Double.valueOf(price), description, 0, Integer.valueOf(stock), thumbnail, subImage1, subImage2, Integer.valueOf(status));
        Boolean checkResult = false;
        try {
            ProductDAOImplement.getInstance().insert(product);
            checkResult = true;
        } catch (Exception e) {
            System.out.println("Create new product failure: " + e);
        }
        if (checkResult) {
            response.sendRedirect(request.getContextPath() + "/manage-product");
        } else {
            request.setAttribute("errorMessage", "Create new product failure!!!");
            request.getRequestDispatcher("manage_product.jsp").forward(request, response);
        }
    }
}
