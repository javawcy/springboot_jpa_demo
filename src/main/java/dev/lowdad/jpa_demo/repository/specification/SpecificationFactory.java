package dev.lowdad.jpa_demo.repository.specification;

import org.springframework.data.jpa.domain.Specification;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
public final class SpecificationFactory<T> {
    public static <T> Specification<T> equal(String attribute, String value) {
        return (r, q, c) -> c.equal(r.get(attribute), value);
    }
}
