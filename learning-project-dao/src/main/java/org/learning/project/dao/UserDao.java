package org.learning.project.dao;

import org.learning.project.domain.persons.SecurityUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends PagingAndSortingRepository<SecurityUser, Long> {
	@Query("SELECT u FROM SecurityUser u WHERE u.username = :username")
	SecurityUser findByUserName(@Param("username") String username);
}
