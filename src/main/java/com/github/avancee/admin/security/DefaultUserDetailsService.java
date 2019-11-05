package com.github.avancee.admin.security;

import com.github.avancee.admin.modules.system.entity.SysUser;
import com.github.avancee.admin.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.loadUserByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        // 授权 GrantedAuthority
        return new AvanceeUserDetails(sysUser, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

}
