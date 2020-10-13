package dev.lowdad.jpa_demo.repository;

import dev.lowdad.jpa_demo.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>, QuerydslPredicateExecutor<Role> {

    @EntityGraph(attributePaths = {"permissions"})
    @Query("select r from Role r")
    List<Role> findAllGraph();
}
