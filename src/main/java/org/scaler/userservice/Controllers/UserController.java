package org.scaler.userservice.Controllers;

import org.scaler.userservice.dtos.LogOutRequestDto;
import org.scaler.userservice.dtos.LoginRequestDto;
import org.scaler.userservice.dtos.SignUpRequestDto;
import org.scaler.userservice.dtos.UserDto;
import org.scaler.userservice.exceptions.UnAuthorizedException;
import org.scaler.userservice.exceptions.UserNotFoundException;
import org.scaler.userservice.models.Token;
import org.scaler.userservice.models.User;
import org.scaler.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto requestDto) throws UserNotFoundException, UnAuthorizedException {
        return userService.login(requestDto.getEmail(), requestDto.getPassword());

    }

    @PostMapping("/signUp")
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto){
        User user = userService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        return UserDto.from(user);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logOut(@RequestBody LogOutRequestDto requestDto){
        userService.logOut(requestDto.getTokenValue());
        return new ResponseEntity<>(
                HttpStatus.OK
        );

    }

    @GetMapping("/validate")
    public UserDto validateToken(@PathVariable String tokenValue){
        return null;
    }

}
