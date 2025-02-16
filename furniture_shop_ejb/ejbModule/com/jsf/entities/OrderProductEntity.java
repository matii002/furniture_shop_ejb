package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the orders_products database table.
 * 
 */
@Entity
@Table(name="order_product")
@NamedQuery(name="OrderProductEntity.findAll", query="SELECT o FROM OrderProductEntity o")
public class OrderProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order_product")
	private int idOrderProduct;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id_order")
	private OrderDetailsEntity orderDetail;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id_product")
	private ProductEntity product;

	public OrderProductEntity() {
	}

	public int getIdOrderProduct() {
		return this.idOrderProduct;
	}

	public void setIdOrderProduct(int idOrderProduct) {
		this.idOrderProduct = idOrderProduct;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDetailsEntity getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetailsEntity orderDetail) {
		this.orderDetail = orderDetail;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}