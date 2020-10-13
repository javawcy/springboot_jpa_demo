package dev.lowdad.jpa_demo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * <p>
 * queryDSL factory config
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/13
 */
@Configuration
public class QueryFactoryConfig {

    private final EntityManager entityManager;

    @Autowired
    public QueryFactoryConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public JPAQueryFactory jpaQuery() {
        return new JPAQueryFactory(entityManager);
    }
}
