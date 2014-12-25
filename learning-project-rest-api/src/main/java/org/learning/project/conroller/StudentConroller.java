package org.learning.project.conroller;

import org.learning.project.domain.persons.Student;
import org.learning.project.service.student.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentConroller {
	private static final Logger LOG = LoggerFactory.getLogger(StudentConroller.class);
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		LOG.info("Creating student : {}", student);
		return studentService.addNewStudent(student);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Student getStudent(@PathVariable Long id) {
		LOG.info("Get student by id : {}", id);
		return studentService.getStudentById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Student> getStudents(Pageable pageable) {
		LOG.info("Get student by id : {}", pageable);
		return studentService.getAllStudents(pageable);
	}

}
