package org.scaler.userservice.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;

@IdClass(UserRolesDto.class)
public class UserRolesDto {

    @Column(name="users_id")
    private int userId;
    @Column(name = "roles_id")
    private int roleId;

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
