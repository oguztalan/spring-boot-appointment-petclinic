package com.oguztalan.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="user_role")
@AllArgsConstructor
@Data
@ToString
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name="user_role_id", unique=true, nullable=false)
	private Integer userRoleId;
	
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


}
