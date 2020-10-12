package dev.lowdad.jpa_demo.repository;

import dev.lowdad.jpa_demo.entity.User;
import dev.lowdad.jpa_demo.entity.simple.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    SimpleUser findSimpleById(Long id);
}
