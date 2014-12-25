package org.learning.project.conroller;

import org.learning.project.service.message.MessageResource;
import org.learning.project.service.message.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

	/**
	 * Method for handling base exceptions.
	 * 
	 * @param e
	 *            input exception.
	 * @return message resource.
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public MessageResource handleException(final Exception e) {
		LOG.error("Handling general exception", e);

		MessageResource message = new MessageResource();
		message.setMessageType(MessageType.WARN);
		message.setMessage(e.getMessage());

		return message;
	}
}