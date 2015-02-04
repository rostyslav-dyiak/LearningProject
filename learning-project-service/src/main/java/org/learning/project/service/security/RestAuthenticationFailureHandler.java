package org.learning.project.service.security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("failureAuthenticatioHandler")
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

}
