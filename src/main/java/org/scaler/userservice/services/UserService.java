package org.scaler.userservice.services;

import org.scaler.userservice.exceptions.UnAuthorizedException;
import org.scaler.userservice.exceptions.UserNotFoundException;
import org.scaler.userservice.models.Token;
import org.scaler.userservice.models.User;

public interface UserService {

    User signUp(String name, String email, String password);
    Token login(String email, String password) throws UserNotFoundException, UnAuthorizedException;
    User validateToken(String tokenValue);
    void logOut(String tokenValue);

}
