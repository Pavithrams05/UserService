package org.scaler.userservice.models;

import jakarta.persistence.*;

@Entity(name = "users_roles")
public class UsersRoles {

    @EmbeddedId
    private UsersRolesId id;

    public UsersRolesId getId() {
        return id;
    }
    public void setId(UsersRolesId id) {
        this.id = id;
    }


}
