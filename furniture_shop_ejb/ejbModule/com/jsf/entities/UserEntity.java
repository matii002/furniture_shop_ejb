package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;

	private String city;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "house_number")
	private String houseNumber;

	private String login;

	@Temporal(TemporalType.DATE)
	@Column(name = "modyfication_date")
	private Date modyficationDate;

	private String pass;

	@Column(name = "post_code")
	private String postCode;

	private String street;

	private String surname;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "user")
	private List<OrderEntity> order;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id_user")
	private UserEntity user;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "user")
	private List<UserEntity> users;

	public UserEntity() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUsers(int idUser) {
		this.idUser = idUser;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getModyficationDate() {
		return this.modyficationDate;
	}

	public void setModyficationDate(Date modyficationDate) {
		this.modyficationDate = modyficationDate;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<OrderEntity> getOrders() {
		return this.order;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.order = orders;
	}

	public OrderEntity addOrder(OrderEntity order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public OrderEntity removeOrder(OrderEntity order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setUser(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setUser(null);

		return user;
	}
	
	@PrePersist
    public void prePersist() {
        if (this.createDate == null) {
            this.createDate = new Date();
        }
    }

}