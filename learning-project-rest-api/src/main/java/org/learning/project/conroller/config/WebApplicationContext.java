package org.learning.project.conroller.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebMvc
@Configuration
@EnableSpringDataWebSupport
@Import(SecurityConfig.class)
@ComponentScan(basePackages = { "org.learning.project.conroller" })
public class WebApplicationContext extends WebMvcConfigurerAdapter {

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Bean
	public Jaxb2RootElementHttpMessageConverter getXmlMessageConverter() {
		return new Jaxb2RootElementHttpMessageConverter();
	}

	@Bean
	public MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setPrettyPrint(true);
		converter.setObjectMapper(new ObjectMapper());
		return converter;
	}

	@Bean
	public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
		adapter.setMessageConverters(Arrays.<HttpMessageConverter<?>> asList(getXmlMessageConverter(), getJsonMessageConverter()));
		return adapter;
	}

}
