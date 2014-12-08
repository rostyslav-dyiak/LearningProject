package org.learning.project.domain.persons;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.learning.project.domain.model.Address;
import org.learning.project.domain.model.Group;

@Entity
@Table(name = "t_teacher")
public class Teacher extends Person {

	private static final long serialVersionUID = 1L;

	@Column(name = "employment_date")
	private Date employmentDate;

	@Column(name = "salary")
	private Long salary;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@Embedded
	private Address address;

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

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
