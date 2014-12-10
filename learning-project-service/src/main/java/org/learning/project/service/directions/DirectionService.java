package org.learning.project.service.directions;

import org.learning.project.domain.model.CourseDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface DirectionService {
	public Page<CourseDirection> getAllDirections(Pageable pagable);

	public Iterable<CourseDirection> getAllDirections(Sort sort);

	public Iterable<CourseDirection> getAllDirections();
	
	public CourseDirection addDirection(CourseDirection direction);

}
