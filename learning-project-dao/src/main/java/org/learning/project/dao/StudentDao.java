package org.learning.project.dao;

import org.learning.project.domain.persons.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public interface StudentDao extends PagingAndSortingRepository<Student, Long> {

}
