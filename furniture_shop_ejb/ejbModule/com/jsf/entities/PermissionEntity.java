package com.jsf.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name = "permission")
@NamedQuery(name = "PermissionEntity.findAll", query = "SELECT p FROM PermissionEntity p")
public class PermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permission")
	private int idPermission;

	@Column(name = "active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "role_id_role")
	private RoleEntity role;

	@Column(name = "set_date")
	private LocalDateTime creationDate;

	@Column(name = "shut_down_date")
	private LocalDateTime shutDownDate;

	@ManyToOne
	@JoinColumn(name = "user_id_user")
	private UserEntity user;

	public PermissionEntity() {
	}

	public int getIdPermissions() {
		return this.idPermission;
	}

	public void setIdPermissions(int idPermissions) {
		this.idPermission = idPermissions;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public RoleEntity getRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public LocalDateTime getCreationDate() {
		return this.creationDate;
	}

	@PostConstruct
	public void setDate() {
		creationDate = LocalDateTime.now();
	}

	public LocalDateTime getShutDownDate() {
		return this.shutDownDate;
	}

	public void setShutDownDate(LocalDateTime shutDownDate) {
		this.shutDownDate = shutDownDate;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}