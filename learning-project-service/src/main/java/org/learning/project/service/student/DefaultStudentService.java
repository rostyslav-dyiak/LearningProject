package org.learning.project.service.student;

import org.learning.project.dao.StudentDao;
import org.learning.project.domain.persons.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DefaultStudentService implements StudentService {
	@Autowired
	private StudentDao dao;

	@Override
	public void addNewStudent(Student student) {
		dao.save(student);
	}

	@Override
	public Iterable<Student> getAllStudents() {
		return dao.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void deleteStudent(Long id) {
		dao.delete(id);
	}

	@Override
	public Page<Student> getAllStudents(Pageable pagable) {
		return dao.findAll(pagable);
	}

	@Override
	public Iterable<Student> getAllStudents(Sort sort) {
		return dao.findAll(sort);
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

}
