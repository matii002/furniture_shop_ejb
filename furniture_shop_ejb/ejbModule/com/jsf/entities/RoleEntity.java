package com.jsf.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name = "RoleEntity.findAll", query = "SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_role")
	private int idRole;

	private String name;

	@OneToMany(mappedBy = "role")
	private List<PermissionEntity> permissions;

	public RoleEntity() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}