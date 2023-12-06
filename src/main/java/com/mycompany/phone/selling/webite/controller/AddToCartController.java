package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.model.Product;
import com.mycompany.phone.selling.webite.DAO.implement.ProductDAOImplement;
import com.mycompany.phone.selling.webite.model.CartItem;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddToCartController", urlPatterns = {"/add-to-cart"})
public class AddToCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập tiếng Việt
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        // Lấy id sản phẩm
        String pId = request.getParameter("productId");
        // Lấy biến check để kiểm tra cho việc chuyển trang
        String redirect = request.getParameter("check");
        Integer redirectCheck = Integer.valueOf(redirect);
        Integer productId = Integer.valueOf(pId);
        Product product = null;
        try {
            product = ProductDAOImplement.getInstance().findById(productId);
        } catch (Exception e) {
            System.out.println(e);
        }
        // Quản lý giỏ hàng bằng session
        HttpSession session = request.getSession();
        // Lấy biến totalPay, cart từ session
        Double totalPay = (Double) session.getAttribute("totalPay");
        Object object = session.getAttribute("cart"); // Lưu tạm giỏ hàng vào session
        // Kiểm tra giỏ hàng có tồn tại hay không?
        if (object == null) { // NẾU KHÔNG thì
            CartItem cartItem = new CartItem();
            cartItem.setProductId(product);
            cartItem.setQuantity(1);
            // Lưu vào map dễ dàng truy xuất với key - id của product / value - cartItem vừa tạo
            // Tạo giỏ hàng mới
            Map<String, CartItem> map = new HashMap<>();
            // Thêm sản phẩm vào giỏ hàng (map) với key là id của sản phẩm và value là cart item
            map.put(pId, cartItem);
            // Lưu giỏ hàng vào session
            session.setAttribute("cart", map);
            // Set lại dữ liệu số lượng sản phẩm là 1
            session.setAttribute("countProduct", 1);
            System.out.println(map);
        } else { // Nếu CÓ thì
            // Lấy ra và ép kiểu thành Map
            Map<String, CartItem> map = (Map<String, CartItem>) object;
            CartItem cartItem = map.get(pId);
            // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
            if (cartItem == null) { //  Nếu CHƯA thì
                // Tạo cart item mới và set số lượng (quantity) là 1
                cartItem = new CartItem();
                cartItem.setProductId(product);
                cartItem.setQuantity(1);
                // Thêm nó vào giỏ hàng
                map.put(pId, cartItem);
            } else { //  Nếu CÓ RỒI thì
                if (redirectCheck.equals(5)) { // Nếu redirectCheck là 5 thì đang giảm số lượng sản phẩm
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                } else { // Số lượng tăng thêm 1
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                }
            }
            Integer count = (Integer )session.getAttribute("countProduct");
            // Sau khi thay đổi số lượng sản phẩm trong giỏ hàng
            if (redirectCheck.equals(5)) { // Nếu redirectCheck là 5 thì đang giảm số lượng sản phẩm
                session.setAttribute("countProduct", count - 1);
            } else { // Số lượng tăng thêm 1
                session.setAttribute("countProduct", count + 1);
            }
            // Lưu lại giỏ hàng
            session.setAttribute("cart", map);
            System.out.println(map);
        }
        // Lưu lại tổng số tiền của giỏ hàng
        if (redirectCheck.equals(5)) { // Nếu redirectCheck là 5 thì đang giảm số lượng sản phẩm
            session.setAttribute("totalPay", totalPay - product.getPrice());
        } else { // Số lượng tăng thêm 1
            session.setAttribute("totalPay", totalPay + product.getPrice());
        }
        // Dựa vào biến check lấy từ input có type = "hidden" để chuyển sang đúng trang
        switch (redirectCheck) {
            case 1 -> {
                System.out.println("Buy Now Product (" + pId + ") - Go to Cart");
                response.sendRedirect(request.getContextPath() + "/cart");
            }
            case 2 -> {
                System.out.println("Add Product (" + pId + ") To Cart");
                response.sendRedirect(request.getContextPath() + "/product");
            }
            case 3 -> {
                System.out.println("Add Product (" + pId + ") To Cart");
                response.sendRedirect(request.getContextPath() + "/product-detail?productId=" + pId);
            }
            case 4 -> {
                System.out.println("Increase Product (" + pId + ") - Return Cart");
                response.sendRedirect(request.getContextPath() + "/cart");
            }
            case 5 -> {
                System.out.println("Decrease Product (" + pId + ") - Return Cart");
                response.sendRedirect(request.getContextPath() + "/cart");
            }
            default -> {
                System.out.println("Redirect failure!");
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
