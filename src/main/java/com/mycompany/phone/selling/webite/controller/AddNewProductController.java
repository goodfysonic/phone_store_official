package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.ProductDAOImplement;
import com.mycompany.phone.selling.webite.constant.PhoneStoreConstant;
import com.mycompany.phone.selling.webite.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddNewProductController", urlPatterns = {"/add-new-product"})
public class AddNewProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("manage_input.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String productName = request.getParameter("productName");
        String brand = request.getParameter("brand");
        String capacity = request.getParameter("capacity");
        String display = request.getParameter("display");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Integer stock = Integer.valueOf(request.getParameter("stock"));
        Double price = Double.valueOf(request.getParameter("price"));
        String thumbnail = request.getParameter("thumbnail");
        String subImage1 = request.getParameter("subImage1");
        String subImage2 = request.getParameter("subImage2");
        Integer status = Integer.valueOf(request.getParameter("status"));
        Product product = new Product(productName, brand, capacity, display, color, price, description, PhoneStoreConstant.PRODUCT_SOLD_DEFAULT, stock, thumbnail, subImage1, subImage2, status);
        try {
            ProductDAOImplement.getInstance().insert(product);
            response.sendRedirect(request.getContextPath() + "/manage-product");
        } catch (Exception e) {
            System.out.println("System Add New Product Error:" + e);
            request.setAttribute("errorMessage", "Create new Product Failure!!!");
            request.getRequestDispatcher("manage_input.jsp").forward(request, response);
        }
    }
}
