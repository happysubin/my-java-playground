package happysubin.javapractice.lab.multi_tx.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
@EntityScan(basePackages = {"happysubin.javapractice.lab.multi_tx.main"})
@EnableJpaRepositories(
        basePackages = {"happysubin.javapractice.lab.multi_tx.main"},
        entityManagerFactoryRef = "mainEntityManagerFactory",
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
    public HikariDataSource mainDataSource(@Qualifier("mainHikariConfig") HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           DataSource dataSource,
                                                                           JpaProperties jpaProperties,
                                                                           HibernateProperties hibernateProperties) {

        Map<String, String> map = new HashMap<>(jpaProperties.getProperties());
        map.put("hibernate.hbm2ddl.auto", hibernateProperties.getDdlAuto());

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(dataSource)
                .packages("happysubin.javapractice.lab.multi_tx.main")
                .persistenceUnit("main")
                .build();

        localContainerEntityManagerFactoryBean.setJpaPropertyMap(map);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    @Primary
    public PlatformTransactionManager mainTransactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}