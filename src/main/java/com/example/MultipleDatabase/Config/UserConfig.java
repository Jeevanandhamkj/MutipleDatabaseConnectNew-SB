package com.example.MultipleDatabase.Config;

import com.example.MultipleDatabase.UserModel.User;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",basePackages = {
        " com.example.MultipleDatabase.UserRepo"
},transactionManagerRef = "transactionManager")
public class UserConfig {


    @Bean(name="datasource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                        @Qualifier("datasource") DataSource dataSource){
        Map<String, Object>pro=new HashMap<>();
        pro.put("hibernate.hbm2ddl.auto","update");
        pro.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");

        return builder.dataSource(dataSource)
                .properties(pro)
                .packages(" com.example.MultipleDatabase.UserModel")
                .persistenceUnit("User").build();
    }
    @Bean(name="transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
