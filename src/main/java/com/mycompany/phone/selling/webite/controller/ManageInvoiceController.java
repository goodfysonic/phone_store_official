package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.InvoiceDAOImplement;
import com.mycompany.phone.selling.webite.model.Invoice;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "ManageInvoiceController", urlPatterns = {"/manage-invoice"})
public class ManageInvoiceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Trả về trang quản lý lịch của người dùng
        try {
            List<Invoice> listHistory = InvoiceDAOImplement.getInstance().findAll();
            request.setAttribute("listHistory", listHistory);
        } catch (Exception e) {
            System.out.println("System Manage History Error: " + e);
        }
	request.getRequestDispatcher("manage_cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
