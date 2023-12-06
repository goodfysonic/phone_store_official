package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.ProductDAOImplement;
import com.mycompany.phone.selling.webite.constant.PhoneStoreConstant;
import com.mycompany.phone.selling.webite.model.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String indexPage = request.getParameter("indexPage");
        String findTitle = request.getParameter("findTitle");
        // Khởi tạo ban đầu cho từ khóa
        if (findTitle == null) {
            findTitle = "";
        }
        // Khởi tạo trang đầu
        if (indexPage == null)
        {
                indexPage = "1";
        }
        int index = Integer.parseInt(indexPage) - 1;
	// Thiết lập dữ liệu truyền cho JSP
        try {
            List<Product> listProduct = ProductDAOImplement.getInstance().findAll(index, PhoneStoreConstant.LIST_PRODUCT_SEARCH_SIZE, findTitle);
            List<Product> checkTotal = ProductDAOImplement.getInstance().findAll(findTitle);
            request.setAttribute("listProduct", listProduct);
            System.out.println(checkTotal.size());
            int totalPage = checkTotal.size() / PhoneStoreConstant.LIST_PRODUCT_SEARCH_SIZE + 1;
            request.setAttribute("indexPage", indexPage);
            System.out.println(indexPage);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("findTitle", findTitle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
        // Trả về trang chủ
	RequestDispatcher rq = request.getRequestDispatcher("search.jsp");// /test/index.jsp");
	rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
