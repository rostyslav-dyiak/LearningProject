package org.learning.project.service.student;

import org.learning.project.dao.StudentDao;
import org.learning.project.domain.persons.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {
	
	@Autowired
	@Qualifier("studentDao")
	private StudentDao dao;

	@Override
	public Student addNewStudent(Student student) {
		return dao.save(student);
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
