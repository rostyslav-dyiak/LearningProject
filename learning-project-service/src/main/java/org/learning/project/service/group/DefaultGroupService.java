package org.learning.project.service.group;

import org.learning.project.dao.GroupDao;
import org.learning.project.domain.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DefaultGroupService implements GroupService {

	@Autowired
	private GroupDao dao;

	@Override
	public void addNewGroup(Group group) {
		dao.save(group);
	}

	@Override
	public Iterable<Group> getAllGroups() {
		return dao.findAll();
	}

	@Override
	public Group getGroupById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void deleteGroup(Long id) {
		dao.delete(id);
	}

	@Override
	public Page<Group> getAllGroups(Pageable pagable) {
		return dao.findAll(pagable);
	}

	@Override
	public Iterable<Group> getAllGroups(Sort sort) {
		return dao.findAll(sort);
	}

}
