package org.learning.project.conroller.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.project.dao.config.RepositoryContext;
import org.learning.project.service.config.ServiceContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  RepositoryContext.class, ServiceContext.class }, loader = AnnotationConfigContextLoader.class)
public class WebApplicationContextTest {
	@Test
	public void initializeSpringContext() {
	}
}
