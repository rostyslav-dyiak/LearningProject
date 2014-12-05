package org.learning.project.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "t_course_direction")
public class CourseDirection extends Model {

	private static final long serialVersionUID = 1L;

	@Column(name = "course_title")
	private String courseTitle;

	@Column(name = "price")
	private Long price;

	@Column(name = "course_description")
	private String courseDescription;

	@Column(name = "direction")
	@Enumerated(EnumType.STRING)
	private Direction direction;

	@OneToMany(mappedBy = "direction")
	private Set<Group> courses;

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Set<Group> getCourses() {
		return courses;
	}

	public void setCourses(Set<Group> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "CourseDirection [courseTitle=" + courseTitle + ", price="
				+ price + ", courseDescription=" + courseDescription
				+ ", direction=" + direction + ", courses=" + courses + "]";
	}

}
