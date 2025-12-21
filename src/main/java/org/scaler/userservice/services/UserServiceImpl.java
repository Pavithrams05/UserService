package org.scaler.userservice.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.scaler.userservice.exceptions.UnAuthorizedException;
import org.scaler.userservice.exceptions.UserNotFoundException;
import org.scaler.userservice.models.Token;
import org.scaler.userservice.models.User;
import org.scaler.userservice.repositories.TokenRepository;
import org.scaler.userservice.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, TokenRepository tokenRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            //redirect to login
            return optionalUser.get();
        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(new ArrayList<>());

        return userRepository.save(user);
    }

    @Override
    public Token login(String email, String password) throws UserNotFoundException, UnAuthorizedException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("user with email " +email+"not found");
        }
        User user = optionalUser.get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            //login successful create token
            Token token = new Token();
            token.setUser(user);
            //DEPRECATED RandomStringUTILS
            token.setValue(RandomStringUtils.randomAlphanumeric(128));

            //Date after 30 days code using Calendar
            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DATE, 30);
            Date expirationDate = calendar.getTime();
            token.setExpiryDate(expirationDate);
            return tokenRepository.save(token);
        }

        throw new UnAuthorizedException("Login Failed");
    }

    @Override
    public User validateToken(String tokenValue) {
        //check if the token is present in DB,token is not deleted
        //token's expiry time is greater than current time

        Optional<Token> optionalToken = tokenRepository.findByValueAndIsDeletedAndExpiryDateGreaterThan(tokenValue, false, new Date());
        return optionalToken.map(Token::getUser).orElse(null);

    }

    @Override
    public void logOut(String tokenValue) {
        Optional<Token> optionalToken = tokenRepository.findByValue(tokenValue);
        if (optionalToken.isEmpty()) {
           throw new RuntimeException("Token not found");
        }
        Token token = optionalToken.get();
        token.setIsDeleted(true);
        tokenRepository.save(token);

    }
}
