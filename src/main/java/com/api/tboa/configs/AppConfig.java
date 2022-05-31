package com.api.tboa.configs;

import com.api.tboa.adapeters.services.EncryptAdapter;
import com.api.tboa.services.EncryptService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableJpaRepositories(basePackages = {"com.api.tboa.DAO"})
public class AppConfig {
    @Bean
    public EncryptAdapter makeEncrypt() {
        return EncryptService.make();
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("JPA_DEMO");
        return factoryBean;
    }
}
