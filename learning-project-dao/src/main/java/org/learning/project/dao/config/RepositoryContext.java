package org.learning.project.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@ComponentScan(basePackages = { "org.learning.project.dao" })
@EnableJpaRepositories(basePackages = { "org.learning.project.dao" })
public class RepositoryContext {

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

	private @Value("${jdbc.driverClassName}") String driver ;
	private @Value("${jdbc.databaseurl}") String databaseUrl;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;

	private @Value("${hibernate.dialect}") String hibrnateDialect;
	private @Value("${hibernate.format_sql}") String formatSql;
	private @Value("${hibernate.ejb.naming_strategy}") String namingStrategy;
	private @Value("${hibernate.show_sql}") String showSQL = "hibernate.show_sql";
	private @Value("${hibernate.hbm2ddl.auto}") String hbm2dllAuto = "hibernate.hbm2ddl.auto";
	private @Value("${entitymanager.packages.to.scan}") String packagesToScan = "entitymanager.packages.to.scan";

	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setLocations(new ClassPathResource("application.properties"));
		return placeholderConfigurer;
	}
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(packagesToScan);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

		Properties jpaProterties = new Properties();
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibrnateDialect);
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, formatSql);
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, namingStrategy);
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, showSQL);
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hbm2dllAuto);

		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		return entityManagerFactoryBean;
	}


}
