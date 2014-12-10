package org.learning.project.conroller;

import org.learning.project.domain.model.CourseDirection;
import org.learning.project.service.teacher.DirectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/directions")
public class DirectionsController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(DirectionsController.class);
	@Autowired
	private DirectionService service;

	/**
	 * POST method for creating feedback.
	 * 
	 * @param feedbackResource
	 *            resource, that will be stored in system.
	 * @return Resource with generated identifier.
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public CourseDirection createFeedback(@RequestBody final CourseDirection courseDirection) {
		LOG.info("Creating feedback: {}", courseDirection);

		return service.addDirection(courseDirection);
	}
}
