package app.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:app/config/properties/database.properties")
public class DataConfig {
	
	@Autowired
	private Environment environment;
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public DataSource dataSource() throws IllegalArgumentException, PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getProperty("dataSource.driverClassName"));
		dataSource.setJdbcUrl(environment.getProperty("dataSource.url"));
		dataSource.setUser(environment.getProperty("dataSource.username"));
		dataSource.setPassword(environment.getProperty("dataSource.password"));
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate()  {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
}
