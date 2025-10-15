package org.scaler.userservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.userservice.models.Role;
import org.scaler.userservice.models.User;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String email;
    private String name;
    private List<Role> roles;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setRoles(user.getRoles());

        return userDto;
    }

}
