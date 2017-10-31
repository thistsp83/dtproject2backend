package com.niit.discussionB.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.discussionB.model.Blog;
import com.niit.discussionB.model.BlogComment;
import com.niit.discussionB.model.Event;
import com.niit.discussionB.model.FileUpload;
import com.niit.discussionB.model.Forum;
import com.niit.discussionB.model.ForumReply;
import com.niit.discussionB.model.Friend;
import com.niit.discussionB.model.Job;
import com.niit.discussionB.model.JobApplied;
import com.niit.discussionB.model.JoinForum;
import com.niit.discussionB.model.User;

@Configuration
@ComponentScan("com.niit.disscussionB")
@EnableTransactionManagement
public class AppConfig{

	@Autowired
	@Bean(name ="dataSource")
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/project");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
	}

	@Autowired
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		
		builder.addAnnotatedClass(User.class);
		builder.addAnnotatedClass(Blog.class);
		builder.addAnnotatedClass(FileUpload.class);
		builder.addAnnotatedClass(BlogComment.class);
		builder.addAnnotatedClass(Event.class);
		builder.addAnnotatedClass(Forum.class);
		builder.addAnnotatedClass(ForumReply.class);
		builder.addAnnotatedClass(Friend.class);
		builder.addAnnotatedClass(Job.class);
		builder.addAnnotatedClass(JobApplied.class);
		builder.addAnnotatedClass(JoinForum.class);
		
		return builder.buildSessionFactory();
	}

	// Create a transaction manager
	@Bean
	@Autowired
	public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	

}
