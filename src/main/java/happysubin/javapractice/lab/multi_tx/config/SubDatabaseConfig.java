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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
@EntityScan(basePackages = {"happysubin.javapractice.lab.multi_tx.sub"})
@EnableJpaRepositories(
        basePackages = {"happysubin.javapractice.lab.multi_tx.sub"},
        entityManagerFactoryRef = "subEntityManagerFactory",
        transactionManagerRef = "subTransactionManager"
)
public class SubDatabaseConfig {

    public static final String SUB_TRANSACTION_MANGER_NAME = "subTransactionManager";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.sub")
    public HikariConfig subHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public HikariDataSource subDataSource(@Qualifier("subHikariConfig") HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean subEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                          @Qualifier("subDataSource") DataSource subDataSource,
                                                                          JpaProperties jpaProperties,
                                                                          HibernateProperties hibernateProperties) {

        Map<String, String> map = new HashMap<>(jpaProperties.getProperties());
        map.put("hibernate.hbm2ddl.auto", hibernateProperties.getDdlAuto());

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(subDataSource)
                .packages("happysubin.javapractice.lab.multi_tx.sub")
                .persistenceUnit("sub")
                .build();

        localContainerEntityManagerFactoryBean.setJpaPropertyMap(map);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager subTransactionManager(@Qualifier("subEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
