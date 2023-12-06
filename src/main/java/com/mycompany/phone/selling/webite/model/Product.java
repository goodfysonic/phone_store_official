package com.mycompany.phone.selling.webite.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.getAll", query = "SELECT p FROM Product p ORDER BY p.id desc"),
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p WHERE p.title LIKE :title ORDER BY p.id desc"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findAllByBrandName", query = "SELECT p FROM Product p WHERE p.brandName = :brandName"),
    @NamedQuery(name = "Product.findAllByBrandNameOrderBySoldDesc", query = "SELECT p FROM Product p WHERE p.brandName = :brandName ORDER BY p.sold desc"),
    @NamedQuery(name = "Product.findAllByCapacity", query = "SELECT p FROM Product p WHERE p.capacity = :capacity"),
    @NamedQuery(name = "Product.findAllByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "display")
    private String display;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private Double price;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @Column(name = "sold")
    private Integer sold;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "thumbnail", columnDefinition = "LONGTEXT")
    private String thumbnail;
    @Column(name = "sub_image1", columnDefinition = "LONGTEXT")
    private String subImage1;
    @Column(name = "sub_image2", columnDefinition = "LONGTEXT")
    private String subImage2;
    @Column(name = "status")
    private Integer status;

    public Product() {
    }

    public Product(String title, String brandName, String capacity, String display, String color, Double price, String description, Integer sold, Integer stock, String thumbnail, String subImage1, String subImage2, Integer status) {
        this.title = title;
        this.brandName = brandName;
        this.capacity = capacity;
        this.display = display;
        this.color = color;
        this.price = price;
        this.description = description;
        this.sold = sold;
        this.stock = stock;
        this.thumbnail = thumbnail;
        this.subImage1 = subImage1;
        this.subImage2 = subImage2;
        this.status = status;
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSubImage1() {
        return subImage1;
    }

    public void setSubImage1(String subImage1) {
        this.subImage1 = subImage1;
    }

    public String getSubImage2() {
        return subImage2;
    }

    public void setSubImage2(String subImage2) {
        this.subImage2 = subImage2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
