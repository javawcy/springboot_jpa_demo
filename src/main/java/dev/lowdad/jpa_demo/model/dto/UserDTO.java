package dev.lowdad.jpa_demo.model.dto;

import dev.lowdad.jpa_demo.entity.Role;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/13
 */
public class UserDTO {

    private String username;
    private Long id;
    private RoleDTO role;

    public UserDTO(Long id, String username, Long roleId, String roleName) {
        this.username = username;
        this.id = id;
        this.role = new RoleDTO(roleId,roleName);
    }
    public UserDTO(String username) {
        this.username = username;
    }

    public UserDTO(Long id, String username, Role role) {
        this.username = username;
        this.id = id;
        this.role = new RoleDTO(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
