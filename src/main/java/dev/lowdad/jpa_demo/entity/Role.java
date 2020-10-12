package dev.lowdad.jpa_demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id")
    )
    private List<Permission> permissions = new ArrayList<>();

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
