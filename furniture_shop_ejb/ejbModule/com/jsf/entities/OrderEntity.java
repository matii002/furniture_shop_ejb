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
@NamedQuery(name="OrderEntity.findAll", query="SELECT o FROM OrderEntity o")
public class OrderEntity implements Serializable {
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
	private UserEntity user;

	//bi-directional many-to-one association to OrdersProduct
	@OneToMany(mappedBy="order")
	private List<OrderProductEntity> ordersProducts;

	public OrderEntity() {
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
		orderProduct.setOrder(this);

		return orderProduct;
	}

	public OrderProductEntity removeOrderProduct(OrderProductEntity orderProduct) {
		getOrdersProducts().remove(orderProduct);
		orderProduct.setOrder(null);

		return orderProduct;
	}

}