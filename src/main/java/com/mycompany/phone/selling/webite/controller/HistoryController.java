package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.InvoiceDAOImplement;
import com.mycompany.phone.selling.webite.model.Account;
import com.mycompany.phone.selling.webite.model.Invoice;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "HistoryController", urlPatterns = {"/history"})
public class HistoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account loggedAccount = (Account) session.getAttribute("loggedAccount");
        try {
            List<Invoice> listInvoice = InvoiceDAOImplement.getInstance().findAllByAccountId(loggedAccount.getId());
            request.setAttribute("listInvoice", listInvoice);
        } catch (Exception e) {
            System.out.println("System History Error: " + e);
        }
        request.getRequestDispatcher("history.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
