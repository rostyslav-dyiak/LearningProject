package org.learning.project.service.teacher;

import org.learning.project.domain.persons.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface TeacherService {

	public void addNewTeacher(Teacher teacher);

	public Iterable<Teacher> getAllTeachers();

	public Teacher getTeacherById(Long id);
	
	public void deleteTeacher(Long id);

	public Page<Teacher> getAllTeachers(Pageable pagable);

	public Iterable<Teacher> getAllTeachers(Sort sort);
}
