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
public class RoleDTO {

    private Long id;
    private String roleName;

    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.roleName = role.getRoleName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
