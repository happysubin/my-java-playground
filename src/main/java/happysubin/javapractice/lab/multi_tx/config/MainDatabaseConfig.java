package happysubin.javapractice.lab.multi_tx.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.statemachine.data.jpa.JpaRepositoryState;
import org.springframework.statemachine.data.jpa.JpaStateRepository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
@EntityScan(
        basePackages = {"happysubin.javapractice.lab.multi_tx.main"}
)
@EnableJpaRepositories(
        basePackages = {"happysubin.javapractice.lab.multi_tx.main"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "mainTransactionManager"
)
public class MainDatabaseConfig {



    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.main")
    public HikariConfig mainHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public HikariDataSource mainDataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           DataSource dataSource,
                                                                           JpaProperties jpaProperties,
                                                                           HibernateProperties hibernateProperties) {

        var properties = hibernateProperties
                .determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());

        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("happysubin.javapractice.lab.multi_tx.main", "org.springframework.statemachine.data.jpa")
                .persistenceUnit("main")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager mainTransactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
