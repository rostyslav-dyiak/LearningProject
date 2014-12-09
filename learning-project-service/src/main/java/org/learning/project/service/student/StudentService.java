package org.learning.project.service.student;

import org.learning.project.domain.persons.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface StudentService {

	public void addNewStudent(Student student);

	public Iterable<Student> getAllStudents();

	public Student getStudentById(Long id);
	
	public void deleteStudent(Long id);

	public Page<Student> getAllStudents(Pageable pagable);

	public Iterable<Student> getAllStudents(Sort sort);
}
