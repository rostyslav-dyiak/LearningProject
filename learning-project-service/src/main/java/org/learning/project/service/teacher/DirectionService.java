package org.learning.project.service.teacher;

import org.learning.project.domain.model.CourseDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface DirectionService {
	public Page<CourseDirection> getAllStudents(Pageable pagable);

	public Iterable<CourseDirection> getAllStudents(Sort sort);

	public Iterable<CourseDirection> getAllStudents();
	
	public CourseDirection addDirection(CourseDirection direction);

}
