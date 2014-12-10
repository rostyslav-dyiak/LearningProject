package org.learning.project.service.teacher;

import org.learning.project.dao.TeacherDao;
import org.learning.project.domain.persons.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DefaultTeacherService implements TeacherService {
	@Autowired
	private TeacherDao dao;

	@Override
	public void addNewTeacher(Teacher Teacher) {
		dao.save(Teacher);
	}

	@Override
	public Iterable<Teacher> getAllTeachers() {
		return dao.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void deleteTeacher(Long id) {
		dao.delete(id);
	}

	@Override
	public Page<Teacher> getAllTeachers(Pageable pagable) {
		return dao.findAll(pagable);
	}

	@Override
	public Iterable<Teacher> getAllTeachers(Sort sort) {
		return dao.findAll(sort);
	}

}
