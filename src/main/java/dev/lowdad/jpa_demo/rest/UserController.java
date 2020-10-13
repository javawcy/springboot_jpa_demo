package dev.lowdad.jpa_demo.rest;

import com.google.common.collect.Lists;
import dev.lowdad.jpa_demo.entity.QRole;
import dev.lowdad.jpa_demo.entity.Role;
import dev.lowdad.jpa_demo.entity.User;
import dev.lowdad.jpa_demo.model.PageResponse;
import dev.lowdad.jpa_demo.repository.RoleRepository;
import dev.lowdad.jpa_demo.repository.UserRepository;
import dev.lowdad.jpa_demo.repository.specification.SpecificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/info")
    public User getUserInfo(@RequestParam("id") User user) {
        return user;
    }

    @GetMapping("/all")
    public PageResponse<User> getUsers(@PageableDefault(page = 0,size = 10) Pageable pageable) {
        return new PageResponse<>(userRepository.findAll(pageable));
    }

    @GetMapping("/lazy")
    public List<User> getUsersTestSessionLazy() {
        return userRepository.findAll(SpecificationFactory.equal("username", "java"));
    }

    @GetMapping("/roles")
    public List<Role> getRoles(@RequestParam("roleName") String roleName) {
        QRole qRole = QRole.role;
        return Lists.newArrayList(roleRepository.findAll(qRole.roleName.eq(roleName)));
    }
}
