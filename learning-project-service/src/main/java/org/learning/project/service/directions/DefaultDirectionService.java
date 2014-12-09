package org.learning.project.service.directions;

import org.learning.project.dao.CourseDirectionDao;
import org.learning.project.domain.model.CourseDirection;
import org.learning.project.service.teacher.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class DefaultDirectionService implements DirectionService {
	@Autowired
	private CourseDirectionDao dao;

	@Override
	public Page<CourseDirection> getAllStudents(Pageable pagable) {
		return dao.findAll(pagable);
	}

	@Override
	public Iterable<CourseDirection> getAllStudents(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Iterable<CourseDirection> getAllStudents() {
		return dao.findAll();
	}

	@Override
	public void addDirection(CourseDirection direction) {
		dao.save(direction);
	}

	public void setDao(CourseDirectionDao dao) {
		this.dao = dao;
	}

}
