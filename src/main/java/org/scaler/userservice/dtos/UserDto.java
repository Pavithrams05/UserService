package org.scaler.userservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.userservice.models.Role;
import org.scaler.userservice.models.User;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
public class UserDto {

    private String email;
    private String name;
    private List<String> roles;

    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setRoles(new ArrayList<>());

        for (Role role : user.getRoles()){
            userDto.getRoles().add(role.getValue());
        }

        return userDto;
    }

}
