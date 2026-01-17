package org.scaler.userservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


//this class is to authenticate all the apis
@Configuration
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests)->{
//
//                    try{
//                        requests
//                                .anyRequest().permitAll()
//                                .and().cors().disable()
//                                .csrf().disable();
//                        }catch (Exception e){
//                        throw new RuntimeException(e);
//                    }
//                });
//        return http.build();
//    }
}
