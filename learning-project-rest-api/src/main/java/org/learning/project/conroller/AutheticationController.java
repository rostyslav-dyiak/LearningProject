package org.learning.project.conroller;

import org.learning.project.domain.persons.SecurityUser;
import org.learning.project.service.security.SecurityUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authetication")
public class AutheticationController {
	private static final Logger LOG = LoggerFactory.getLogger(AutheticationController.class);

	@Autowired
	@Qualifier("userDetailsService")
	private SecurityUserDetailService userService;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public SecurityUser createUser(@RequestBody SecurityUser user) {
		LOG.info("Creating user : {}", user);
		return userService.registerUser(user);
	}
	
	@RequestMapping(value = "/{username}",method = RequestMethod.GET)
	public UserDetails createUser(@PathVariable String username) {
		return userService.loadUserByUsername(username);
	}

}
