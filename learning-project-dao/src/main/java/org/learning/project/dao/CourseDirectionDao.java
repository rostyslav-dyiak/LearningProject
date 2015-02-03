package org.learning.project.dao;

import org.learning.project.domain.model.CourseDirection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("courseDirectionDao")
public interface CourseDirectionDao extends PagingAndSortingRepository<CourseDirection, Long>{

}
