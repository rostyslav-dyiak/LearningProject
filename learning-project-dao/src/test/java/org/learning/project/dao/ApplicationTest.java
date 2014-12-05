package org.learning.project.dao;

import org.junit.Test;
import org.learning.project.dao.config.RepositoryContext;
import org.learning.project.domain.persons.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {

	@Test
	public void testApplication() {
		AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext();
		rootContext.register(RepositoryContext.class);
		rootContext.refresh();
		TeacherDao bean1 = rootContext.getBean(TeacherDao.class);
		bean1.save(new Teacher());
		rootContext.close();

	}
}
