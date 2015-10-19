package app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:app/config/properties/database.properties")
public class PersistenceConfig {
	
	@Autowired
	private Environment env;
	
   @Bean
   @Autowired
   public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource);
      sessionFactory.setPackagesToScan(new String[] { "app.config.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
      return sessionFactory;
   }
   
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);

      return txManager;
   }
   
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
   
   @Bean
   @Autowired
   public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory){
	   //sessionFactory.getCurrentSession().setFlushMode(FlushMode.ALWAYS);
	   HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
	   //hibernateTemplate.setCheckWriteOperations(false);
	   //hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
	   return hibernateTemplate;
   }
	 
	
	Properties hibernateProperties() {
      return new Properties() {
         {
        	//setProperty("hibernate.current_session_context_class","thread"); //test
        	setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        	setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        	setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        	setProperty("hibernate.default_schema", env.getProperty("hibernate.default_schema"));
        	setProperty("hibernate.max_fetch_depth", env.getProperty("hibernate.max_fetch_depth"));
        	setProperty("hibernate.default_batch_fetch_size", env.getProperty("hibernate.default_batch_fetch_size"));
            setProperty("hibernate.use_sql_comments", env.getProperty("hibernate.use_sql_comments"));
            setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
            setProperty("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
            setProperty("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
            setProperty("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
            setProperty("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
            setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto")); //schema update
         }
      };
	}

}
