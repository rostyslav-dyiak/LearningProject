package org.learning.project.service.group;

import org.learning.project.domain.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface GroupService {

	public void addNewGroup(Group group);

	public Iterable<Group> getAllGroups();

	public Group getGroupById(Long id);
	
	public void deleteGroup(Long id);

	public Page<Group> getAllGroups(Pageable pagable);

	public Iterable<Group> getAllGroups(Sort sort);
}
