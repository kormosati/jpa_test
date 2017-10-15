package hu.test.dynamic.dynamictables;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Optional;

@Service
public class EntityManagerFactoryUtil {

    private EntityManagerFactory entityManagerFactory;

    public void setEntityManagerFactory(Optional<String> packageName) {
        entityManagerFactory = createEntityManagerFactory(packageName.get());
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            setEntityManagerFactory(Optional.of("hu.test.dynamic.dynamictables.domain"));
        }
        return entityManagerFactory;
    }

    private EntityManagerFactory createEntityManagerFactory(String packageName) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        bean.setDataSource(dataSource());
        bean.setJpaVendorAdapter(jpaVendorAdapter());
        bean.setPackagesToScan(packageName);
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
