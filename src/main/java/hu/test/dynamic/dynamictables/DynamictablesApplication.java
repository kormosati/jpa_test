package hu.test.dynamic.dynamictables;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.HashMap;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "hu.test.dynamic")
public class DynamictablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamictablesApplication.class, args);
	}

//	@Bean("myEntityManagerFactory")
//	public EntityManagerFactory entityManagerFactoryBean() {
//
//		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//		bean.setDataSource(dataSource());
//		bean.setJpaVendorAdapter(jpaVendorAdapter());
//		bean.setPackagesToScan("hu.test.dynamic.dynamictables.domain");
//		bean.afterPropertiesSet();
//		return bean.getObject();
//	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
}
