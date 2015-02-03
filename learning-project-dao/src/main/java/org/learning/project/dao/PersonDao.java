package org.learning.project.dao;

import org.learning.project.domain.persons.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository("personDao")
public interface PersonDao extends PagingAndSortingRepository<Person, Long> {

}
