package dev.lowdad.jpa_demo.repository;

import dev.lowdad.jpa_demo.JpaDemoApplicationTests;
import dev.lowdad.jpa_demo.entity.Permission;
import dev.lowdad.jpa_demo.entity.Role;
import dev.lowdad.jpa_demo.entity.RolePermission;
import dev.lowdad.jpa_demo.entity.User;
import dev.lowdad.jpa_demo.entity.simple.SimpleUser;
import dev.lowdad.jpa_demo.enums.Gender;
import dev.lowdad.jpa_demo.repository.specification.SpecificationFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
public class JpaRepositoryTests extends JpaDemoApplicationTests {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void TestCreatePermission() {
        Permission permission = new Permission();
        permission.setPermissionName("api");
        permissionRepository.save(permission);
        System.out.println(permission.toString());
    }

    @Test
    void TestCreateRole() {
        Role role = new Role();
        role.setRoleName("admin");
        roleRepository.save(role);
        System.out.println(role.toString());
    }

    @Test
    void TestCreateRolePermission() {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setPermissionId(1L);
        rolePermission.setRoleId(1L);
        rolePermissionRepository.save(rolePermission);
        System.out.println(rolePermission.toString());
    }

    @Test
    void TestGetRole() {
        final List<Role> all = roleRepository.findAllGraph();
        System.out.println(all.toString());
        final Role one = roleRepository.getOne(1L);
        System.out.println(one.toString());
    }

    @Test
    void TestUpdateRole() {
        Role one = roleRepository.getOne(1L);
        List<Permission> permissions = one.getPermissions();
        Permission permission = new Permission();
        permission.setPermissionName("management");
        permissions.add(permission);
        roleRepository.save(one);
        System.out.println(one.toString());
    }

    @Test
    void TestCascadeUpdateRole() {
        Role one = roleRepository.getOne(1L);
        List<Permission> permissions = one.getPermissions();
        Permission permission = permissionRepository.getOne(3L);
        permissions.add(permission);
        roleRepository.save(one);
        System.out.println(one.toString());
    }

    @Test
    void TestCreateUser() {
        Role role = roleRepository.getOne(1L);
        User user = new User();
        user.setAge(14);
        user.setUsername("golang");
        user.setGender(Gender.MALE);
//        user.setRole(role);
        userRepository.save(user);
        user.setRole(role);
        userRepository.save(user);
        System.out.println(user.toString());
    }

    @Test
    void TestUpdateUser() {
        User user = userRepository.getOne(1L);
        Role role = roleRepository.getOne(1L);
        user.setRole(role);
        userRepository.save(user);
        System.out.println(user.toString());
    }

    @Test
    void TestFindUser() {
        User user = userRepository.getOne(1L);
        System.out.println(user.toString());
    }

    @Test
    void TestFindRole() {
        List<Role> role = roleRepository.findAllGraph();
        System.out.println(role.toString());
    }

    @Test
    void TestCascadeUpdate() {

        User user = userRepository.getOne(1L);
        List<Permission> permissions = user.getRole().getPermissions();
        Permission permission = new Permission();
        permission.setPermissionName("app");
        permissions.add(permission);
        userRepository.save(user);

        System.out.println(user.toString());
    }

    @Test
    void TestSimpleUser() {
        SimpleUser user = userRepository.findSimpleById(1L);
        System.out.println(user.getUsername());
        System.out.println(user.getAge());

    }

    @Test
    void TestExampleQuery() {

        User user = new User();
        user.setUsername("java");
        final List<User> all = userRepository.findAll(Example.of(user));
        System.out.println(1);

    }


    @Test
    void TestSpecificationQuery() {

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("username"), "java");
            }
        };

        final List<User> all = userRepository.findAll(specification);
        System.out.println(all);

    }

    @Test
    void TestSpecificationFactoryQuery() {

        final List<User> all = userRepository.findAll(SpecificationFactory.equal("username", "java"));
        System.out.println(all);

    }
}
