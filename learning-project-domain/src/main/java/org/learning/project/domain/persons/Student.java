package org.learning.project.domain.persons;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.learning.project.domain.model.Address;
import org.learning.project.domain.model.Group;

@Entity
@Table(name = "t_student")
public class Student extends Person {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;
	
	@Embedded
	private Address address;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
