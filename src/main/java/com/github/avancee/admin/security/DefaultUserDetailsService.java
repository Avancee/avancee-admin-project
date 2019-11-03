package com.github.avancee.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * DefaultUserDetailsService
 *
 * @author byference
 * @since 2019-11-03
 */
@Component
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final String password = passwordEncoder.encode("123456");
        return new User("user", password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

}
