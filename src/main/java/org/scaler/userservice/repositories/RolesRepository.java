package org.scaler.userservice.repositories;

import org.scaler.userservice.dtos.UserRolesDto;
import org.scaler.userservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {

    Role findByValue(String value);

    @Override
    Role save(Role role);

//    UserRolesDto save(UserRolesDto userRolesDto);
}
