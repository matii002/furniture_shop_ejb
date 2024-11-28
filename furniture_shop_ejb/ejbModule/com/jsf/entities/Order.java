package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order")
	private int idOrder;

	@Column(name="full_price")
	private double fullPrice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date")
	private Date orderDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_finish")
	private Date orderFinish;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id_user")
	private User user;

	//bi-directional many-to-one association to OrdersProduct
	@OneToMany(mappedBy="order")
	private List<OrderProduct> ordersProducts;

	public Order() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public double getFullPrice() {
		return this.fullPrice;
	}

	public void setFullPrice(double fullPrice) {
		this.fullPrice = fullPrice;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderFinish() {
		return this.orderFinish;
	}

	public void setOrdeFinish(Date orderFinish) {
		this.orderFinish = orderFinish;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderProduct> getOrdersProducts() {
		return this.ordersProducts;
	}

	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.ordersProducts = orderProduct;
	}

	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		getOrdersProducts().add(orderProduct);
		orderProduct.setOrder(this);

		return orderProduct;
	}

	public OrderProduct removeOrderProduct(OrderProduct orderProduct) {
		getOrdersProducts().remove(orderProduct);
		orderProduct.setOrder(null);

		return orderProduct;
	}

}