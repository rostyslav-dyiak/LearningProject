package org.learning.project.dao;

import org.learning.project.domain.persons.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonDao extends PagingAndSortingRepository<Person, Long> {

}
