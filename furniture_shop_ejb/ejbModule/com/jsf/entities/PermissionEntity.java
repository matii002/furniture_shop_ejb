package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

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
	private byte active;

	@ManyToOne
	@JoinColumn(name = "role_id_role")
	private RoleEntity role;

	@Temporal(TemporalType.DATE)
	@Column(name = "set_date")
	private Date setDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "shut_down_date")
	private Date shutDownDate;

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

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public RoleEntity getdRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public Date getSetDate() {
		return this.setDate;
	}

	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}

	public Date getShutDownDate() {
		return this.shutDownDate;
	}

	public void setShutDownDate(Date shutDownDate) {
		this.shutDownDate = shutDownDate;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser (UserEntity user) {
		this.user = user;
	}

}