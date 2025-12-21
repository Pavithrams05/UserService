package org.scaler.userservice.repositories;

import org.scaler.userservice.dtos.UserRolesDto;
import org.scaler.userservice.models.UsersRoles;
import org.scaler.userservice.models.UsersRolesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UsersRoles, UsersRolesId> {

    UsersRoles save(UsersRoles usersRoles);

}
