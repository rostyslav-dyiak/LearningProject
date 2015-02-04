package org.learning.project.domain.persons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_user_roles", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "user_name" }))
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id", unique = true, nullable = false)
	private Long userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_name", nullable = false)
	private SecurityUser user;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;

	public UserRole() {
	}

	public UserRole(SecurityUser user, String role) {
		this.user = user;
		this.role = role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
