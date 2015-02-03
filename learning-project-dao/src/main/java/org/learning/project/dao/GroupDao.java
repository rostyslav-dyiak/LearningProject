package org.learning.project.dao;

import org.learning.project.domain.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public interface GroupDao extends PagingAndSortingRepository<Group, Long> {

}
