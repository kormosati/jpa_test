package hu.test.dynamic.dynamictables.controller;

import hu.test.dynamic.dynamictables.EntityManagerFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by attila.kormos on 2017. 10. 16..
 */
@Configuration
@EnableTransactionManagement
public class TransactionManager {

    @Autowired
    private EntityManagerFactoryUtil entityManagerFactoryUtil;

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryUtil.getEntityManagerFactory());
        return jpaTransactionManager;
    }


}
