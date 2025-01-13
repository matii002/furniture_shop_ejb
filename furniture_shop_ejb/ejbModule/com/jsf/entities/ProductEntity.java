package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="ProductEntity.findAll", query="SELECT p FROM ProductEntity p")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_product")
	private int idProduct;

	@Column(name = "availibility")
	private byte availibility;

	@Column(name = "material")
	private String material;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "image_url")
	private String imageUrl;

	//bi-directional many-to-one association to OrdersProduct
	@OneToMany(mappedBy="product")
	private List<OrderProductEntity> orderProduct;

	public ProductEntity() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<OrderProductEntity> getOrderProduct() {
		return this.orderProduct;
	}

	public void setOrderProduct(List<OrderProductEntity> orderProduct) {
		this.orderProduct = orderProduct;
	}

	public OrderProductEntity addOrderProduct(OrderProductEntity orderProduct) {
		getOrderProduct().add(orderProduct);
		orderProduct.setProduct(this);

		return orderProduct;
	}

	public OrderProductEntity removeOrderProduct(OrderProductEntity orderProduct) {
		getOrderProduct().remove(orderProduct);
		orderProduct.setProduct(null);

		return orderProduct;
	}

}