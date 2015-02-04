package org.learning.project.domain.persons;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_users")
public class SecurityUser {
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 60)
	private String username;
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	@Column(name = "enabled", nullable = false, columnDefinition = "BIT")
	private boolean enabled;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole;

	public SecurityUser() {
		userRole = new HashSet<UserRole>();
	}

	public SecurityUser(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		userRole = new HashSet<UserRole>();
	}

	public SecurityUser(String username, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
}
