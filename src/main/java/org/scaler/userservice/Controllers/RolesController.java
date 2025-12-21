package org.scaler.userservice.Controllers;

import org.scaler.userservice.dtos.SignUpRequestDto;
import org.scaler.userservice.dtos.UserDto;
import org.scaler.userservice.dtos.UserRolesDto;
import org.scaler.userservice.models.Role;
import org.scaler.userservice.models.User;
import org.scaler.userservice.models.UsersRoles;
import org.scaler.userservice.models.UsersRolesId;
import org.scaler.userservice.repositories.RolesRepository;
import org.scaler.userservice.repositories.UserRolesRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RolesController {

    private RolesRepository rolesRepository;
    private UserRolesRepository userRolesRepository;

    public RolesController(RolesRepository rolesRepository, UserRolesRepository userRolesRepository) {
        this.rolesRepository = rolesRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @PostMapping("/create")
    public Role create(@RequestBody Role role){
       return rolesRepository.save(role);
    }


    //error in userRoles not yet solved to save the FK in table
    @PostMapping("/userRoles")
    public void createUserRoles(@RequestBody UsersRolesId usersRolesId){
        UsersRoles userRoles = new UsersRoles();
        userRoles.setId(usersRolesId);
        System.out.println("roles id===================="+userRoles.getId().getRole_id());
        System.out.println("userid==================="+userRoles.getId().getUser_id());
         userRolesRepository.save(userRoles);
    }
}
