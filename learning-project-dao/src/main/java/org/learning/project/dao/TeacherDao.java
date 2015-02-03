package org.learning.project.dao;

import org.learning.project.domain.persons.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("teacherDao")
public interface TeacherDao extends PagingAndSortingRepository<Teacher, Long> {

}
