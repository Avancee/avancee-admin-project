package com.github.avancee.admin.security;

import com.github.avancee.admin.constant.SecurityConst;
import com.github.avancee.admin.modules.system.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Objects;

/**
 * AvanceeUserDetails
 *
 * @author byference
 * @since 2019-11-04
 */
public class AvanceeUserDetails extends User {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final SysUser sysUser;

    public AvanceeUserDetails(SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {
        this(sysUser, true, true, true, !Objects.equals(sysUser.getUserState(), SecurityConst.ACCOUNT_LOCKED), authorities);
    }

    public AvanceeUserDetails(SysUser sysUser, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(sysUser.getUserName(), sysUser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.sysUser = sysUser;
        this.sysUser.setPassword(null);
    }

    public Integer getId() {
        return sysUser.getId();
    }
}
