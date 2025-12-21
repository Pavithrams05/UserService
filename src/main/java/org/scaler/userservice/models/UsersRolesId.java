package org.scaler.userservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
public class UsersRolesId implements Serializable {


    @Getter
    @Column(name = "roles_id")
    private int role_id;

    @Column(name = "users_id")
    private int user_id;

    public int getRole_id() {
            return role_id;
    }

    public int getUser_id() {
            return user_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
