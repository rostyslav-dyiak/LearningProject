package org.learning.project.conroller;

import org.learning.project.domain.model.CourseDirection;
import org.learning.project.service.directions.DirectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/directions")
public class DirectionsController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(DirectionsController.class);
	@Autowired
	@Qualifier("directionService")
	private DirectionService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public CourseDirection createFeedback(@RequestBody final CourseDirection courseDirection) {
		LOG.info("Creating direction: {}", courseDirection);

		return service.addDirection(courseDirection);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<CourseDirection> getAllDirectionsFeedback() {
		LOG.info("Returning all directions from database");
		return service.getAllDirections();
	}
}
