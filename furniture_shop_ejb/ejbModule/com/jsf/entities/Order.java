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
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_orders")
	private int idOrders;

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
	@JoinColumn(name="users_id_users")
	private User user;

	//bi-directional many-to-one association to OrdersProduct
	@OneToMany(mappedBy="order")
	private List<OrdersProduct> ordersProducts;

	public Order() {
	}

	public int getIdOrders() {
		return this.idOrders;
	}

	public void setIdOrders(int idOrders) {
		this.idOrders = idOrders;
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

	public void setOrderFinish(Date orderFinish) {
		this.orderFinish = orderFinish;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrdersProduct> getOrdersProducts() {
		return this.ordersProducts;
	}

	public void setOrdersProducts(List<OrdersProduct> ordersProducts) {
		this.ordersProducts = ordersProducts;
	}

	public OrdersProduct addOrdersProduct(OrdersProduct ordersProduct) {
		getOrdersProducts().add(ordersProduct);
		ordersProduct.setOrder(this);

		return ordersProduct;
	}

	public OrdersProduct removeOrdersProduct(OrdersProduct ordersProduct) {
		getOrdersProducts().remove(ordersProduct);
		ordersProduct.setOrder(null);

		return ordersProduct;
	}

}