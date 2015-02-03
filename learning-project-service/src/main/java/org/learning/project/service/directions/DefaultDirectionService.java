package org.learning.project.service.directions;

import org.learning.project.dao.CourseDirectionDao;
import org.learning.project.domain.model.CourseDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DefaultDirectionService implements DirectionService {
	
	@Autowired
	@Qualifier("courseDirectionDao")
	private CourseDirectionDao dao;

	@Override
	public Page<CourseDirection> getAllDirections(Pageable pagable) {
		return dao.findAll(pagable);
	}

	@Override
	public Iterable<CourseDirection> getAllDirections(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Iterable<CourseDirection> getAllDirections() {
		return dao.findAll();
	}

	@Override
	public CourseDirection addDirection(CourseDirection direction) {
		return dao.save(direction);
	}

	public void setDao(CourseDirectionDao dao) {
		this.dao = dao;
	}

}
