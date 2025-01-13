package com.jsf.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="order_details")
@NamedQuery(name="OrderDetailsEntity.findAll", query="SELECT o FROM OrderDetailsEntity o")
public class OrderDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order")
	private int idOrder;

	@Column(name="full_price")
	private Double fullPrice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date")
	private LocalDateTime orderDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_finish")
	private LocalDateTime orderFinish;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id_user")
	private UserEntity user;

	//bi-directional many-to-one association to OrdersProduct
	@OneToMany(mappedBy="orderDetail")
	private List<OrderProductEntity> ordersProducts;
	
	public OrderDetailsEntity() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Double getFullPrice() {
		return this.fullPrice;
	}

	public void setFullPrice(Double fullPrice) {
		this.fullPrice = fullPrice;
	}

	public LocalDateTime getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getOrderFinish() {
		return this.orderFinish;
	}

	public void setOrderFinish(LocalDateTime orderFinish) {
		this.orderFinish = orderFinish;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<OrderProductEntity> getOrdersProducts() {
		return this.ordersProducts;
	}

	public void setOrderProduct(List<OrderProductEntity> orderProduct) {
		this.ordersProducts = orderProduct;
	}

	public OrderProductEntity addOrderProduct(OrderProductEntity orderProduct) {
		getOrdersProducts().add(orderProduct);
		orderProduct.setOrderDetail(this);

		return orderProduct;
	}

	public OrderProductEntity removeOrderProduct(OrderProductEntity orderProduct) {
		getOrdersProducts().remove(orderProduct);
		orderProduct.setOrderDetail(null);

		return orderProduct;
	}

}