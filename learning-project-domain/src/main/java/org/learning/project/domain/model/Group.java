package org.learning.project.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.learning.project.domain.persons.Student;
import org.learning.project.domain.persons.Teacher;

@Entity
@Table(name = "t_group")
public class Group extends Model {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "direction_id")
	private CourseDirection direction;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@OneToMany(mappedBy = "group")
	private Set<Student> students;


	public CourseDirection getDirection() {
		return direction;
	}

	public void setDirection(CourseDirection direction) {
		this.direction = direction;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Group [direction=" + direction + ", students=" + students
				+ ", teacher=" + teacher + "]";
	}

}
