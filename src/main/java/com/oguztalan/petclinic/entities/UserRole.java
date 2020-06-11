package com.oguztalan.petclinic.entities;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name="user_role_id", unique=true, nullable=false)
	private int userRoleId;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="username", nullable=false)
	private User user;
	
	@Column(name="role", nullable=false)
	private String role;

	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	
	public UserRole() {}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
