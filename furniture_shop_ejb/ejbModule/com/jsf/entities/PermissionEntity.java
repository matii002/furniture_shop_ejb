package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name = "permissions")
@NamedQuery(name = "PermissionEntity.findAll", query = "SELECT p FROM PermissionEntity p")
public class PermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permissions")
	private int idPermissions;

	private byte active;

	@Column(name = "role_id_role")
	private int roleIdRole;

	@Temporal(TemporalType.DATE)
	@Column(name = "set_date")
	private Date setDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "shut_down_date")
	private Date shutDownDate;

	@Column(name = "users_id_users")
	private int usersIdUsers;

	public PermissionEntity() {
	}

	public int getIdPermissions() {
		return this.idPermissions;
	}

	public void setIdPermissions(int idPermissions) {
		this.idPermissions = idPermissions;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public int getRoleIdRole() {
		return this.roleIdRole;
	}

	public void setRoleIdRole(int roleIdRole) {
		this.roleIdRole = roleIdRole;
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

	public int getUsersIdUsers() {
		return this.usersIdUsers;
	}

	public void setUsersIdUsers(int usersIdUsers) {
		this.usersIdUsers = usersIdUsers;
	}

}