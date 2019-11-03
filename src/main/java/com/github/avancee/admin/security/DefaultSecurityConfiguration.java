package com.github.avancee.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * DefaultSecurityConfiguration
 *
 * @author byference
 * @since 2019-11-03
 */
@Configuration
public class DefaultSecurityConfiguration {

    @Bean
    public PasswordEncoder defaultPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
