package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the orders_products database table.
 * 
 */
@Entity
@Table(name="orders_products")
@NamedQuery(name="OrdersProduct.findAll", query="SELECT o FROM OrdersProduct o")
public class OrdersProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_orders_products")
	private int idOrdersProducts;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orders_id_order")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="products_id_product")
	private Product product;

	public OrdersProduct() {
	}

	public int getIdOrdersProducts() {
		return this.idOrdersProducts;
	}

	public void setIdOrdersProducts(int idOrdersProducts) {
		this.idOrdersProducts = idOrdersProducts;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}