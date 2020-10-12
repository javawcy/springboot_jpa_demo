package dev.lowdad.jpa_demo.repository;

import dev.lowdad.jpa_demo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
