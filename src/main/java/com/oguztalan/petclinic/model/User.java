package com.oguztalan.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {

	private Long id;
	private String username;
	private String password;
	private boolean active;
	private String email;
	private Set<UserRole> userRole = new HashSet<UserRole>();


}
