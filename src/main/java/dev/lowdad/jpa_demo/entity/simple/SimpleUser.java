package dev.lowdad.jpa_demo.entity.simple;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
public interface SimpleUser {
    String getUsername();

    @Value("#{'年龄是'+target.age}")
    String getAge();
}
