package com.mycompany.phone.selling.webite.controller;

import com.mycompany.phone.selling.webite.DAO.implement.CartItemDAOImplement;
import com.mycompany.phone.selling.webite.DAO.implement.InvoiceDAOImplement;
import com.mycompany.phone.selling.webite.DAO.implement.ShoppingCartDAOImplement;
import com.mycompany.phone.selling.webite.constant.PhoneStoreConstant;
import com.mycompany.phone.selling.webite.model.Account;
import com.mycompany.phone.selling.webite.model.CartItem;
import com.mycompany.phone.selling.webite.model.Invoice;
import com.mycompany.phone.selling.webite.model.ShoppingCart;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CheckOutController", urlPatterns = {"/check-out"})
public class CheckOutController extends HttpServlet {
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
        Account account = (Account) session.getAttribute("loggedAccount");
        Double totalPay = (Double) session.getAttribute("totalPay");
        Integer count = (Integer) session.getAttribute("countProduct");
        String deliveryAddress = request.getParameter("deliveryAddress");
        String shipping = request.getParameter("shippingCost");
        Double shippingCost = Double.valueOf(shipping);
        // Lấy giỏ hàng từ session và ép kiểu sang Map
        Object object = session.getAttribute("cart");
        Map<String, CartItem> map = (Map<String, CartItem>) object;
        // Tạo List để lưu trữ CartItem của Shopping Cart - giỏ hàng thực sự bên dưới database
        List<CartItem> listCartItem = new ArrayList<>();
        // Tạo giỏ hàng thực sự - ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setAccountId(account);
        shoppingCart.setStatus(PhoneStoreConstant.STATUS_ACTIVE);
        // Lưu giỏ hàng xuống database
        try {
            ShoppingCartDAOImplement.getInstance().insert(shoppingCart);
        } catch (Exception e) {
            System.out.println("Error create Shopping Cart");
        }
        // Lấy tất cả CartItem từ giỏ hàng ở session lưu vào giỏ hàng bên dưới database - ShoppingCart
        for (Map.Entry<String, CartItem> entry: map.entrySet()) {
            try {
                entry.getValue().setShoppingCartId(shoppingCart);
                // Lưu CartItem bên dưới database
                CartItemDAOImplement.getInstance().insert(entry.getValue());
            } catch (Exception e) {
            System.out.println("Error create CartItem: " + entry.getKey());
            }
            // Thêm dữ liệu vào list CartItem của ShoppingCart gửi dữ liệu sang trang checkout
            listCartItem.add(entry.getValue());
        }
        shoppingCart.setCardItemList(listCartItem);
        
        // Tạo hóa đơn
        Invoice invoice = new Invoice();
        invoice.setShoppingCartId(shoppingCart.getId());
        invoice.setPaymentMethod(PhoneStoreConstant.PAYMENT_METHOD_CASH);
        // Trạng thái là Active - 1 là đã thanh toán (Sau này khi bên trang admin có nút xác nhận đã giao hàng thì chuyển thành DONE - 2)
        invoice.setStatus(PhoneStoreConstant.STATUS_ACTIVE);
        // Số tiền tổng thực sự thì công thêm tiền ship
        invoice.setTotalPay(totalPay + shippingCost);
        invoice.setPurchasedDate(new Date());
        invoice.setDeliveryAddress(deliveryAddress);
        invoice.setAccountId(shoppingCart.getAccountId().getId());
        try {
            InvoiceDAOImplement.getInstance().insert(invoice);
        } catch (Exception e) {
            System.out.println("Error create Invoice");
        }
        // Sau khi lưu database
        totalPay = 0D;
        session.setAttribute("totalPay", totalPay);
        count = 0;
        session.setAttribute("countProduct", count);
        session.removeAttribute("cart");
        request.setAttribute("shoppingCart", shoppingCart);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}
