package com.mycompany.phone.selling.webite.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT t FROM Invoice t"),
    @NamedQuery(name = "Invoice.findById", query = "SELECT t FROM Invoice t WHERE t.id = :id"),
    @NamedQuery(name = "Invoice.findAllByAccountId", query = "SELECT t FROM Invoice t WHERE t.accountId = :accountId"),
    @NamedQuery(name = "Invoice.findByShoppingCartId", query = "SELECT t FROM Invoice t WHERE t.shoppingCartId = :shoppingCartId"),
    @NamedQuery(name = "Invoice.findAllByStatus", query = "SELECT t FROM Invoice t WHERE t.status = :status")})
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "shopping_cart_id")
    private Integer shoppingCartId;
    @Column(name = "purchased_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchasedDate;
    @Column(name = "total_pay")
    private Double totalPay;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "status")
    private Integer status;

    public Invoice(Integer accountId, Integer shoppingCartId, Date purchasedDate, Double totalPay, String deliveryAddress, String paymentMethod, Integer status) {
        this.accountId = accountId;
        this.shoppingCartId = shoppingCartId;
        this.purchasedDate = purchasedDate;
        this.totalPay = totalPay;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Invoice() {
    }

    public Invoice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }  

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
}
