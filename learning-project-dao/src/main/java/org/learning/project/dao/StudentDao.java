package org.learning.project.dao;

import org.learning.project.domain.persons.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentDao extends PagingAndSortingRepository<Student, Long> {

}
