package org.learning.project.service.teacher;

import org.learning.project.domain.model.CourseDirection;
import org.learning.project.domain.persons.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface DirectionService {
	public Page<Student> getAllStudents(Pageable pagable);

	public Iterable<Student> getAllStudents(Sort sort);

	public Iterable<Student> getAllStudents();
	
	public void addDirection(CourseDirection direction);

}
