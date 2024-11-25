package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_products")
	private int idProducts;

	private byte availibility;

	private String material;

	private String name;

	private double price;

	private int quantity;

	//bi-directional many-to-one association to OrdersProduct
	@OneToMany(mappedBy="product")
	private List<OrdersProduct> ordersProducts;

	public Product() {
	}

	public int getIdProducts() {
		return this.idProducts;
	}

	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
	}

	public byte getAvailibility() {
		return this.availibility;
	}

	public void setAvailibility(byte availibility) {
		this.availibility = availibility;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<OrdersProduct> getOrdersProducts() {
		return this.ordersProducts;
	}

	public void setOrdersProducts(List<OrdersProduct> ordersProducts) {
		this.ordersProducts = ordersProducts;
	}

	public OrdersProduct addOrdersProduct(OrdersProduct ordersProduct) {
		getOrdersProducts().add(ordersProduct);
		ordersProduct.setProduct(this);

		return ordersProduct;
	}

	public OrdersProduct removeOrdersProduct(OrdersProduct ordersProduct) {
		getOrdersProducts().remove(ordersProduct);
		ordersProduct.setProduct(null);

		return ordersProduct;
	}

}