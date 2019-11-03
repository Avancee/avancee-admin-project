package com.github.avancee.admin.modules.system.service;

import com.github.avancee.admin.modules.system.entity.SysUser;
import com.github.avancee.admin.modules.system.entity.SysUserExample;
import com.github.avancee.admin.modules.system.mapper.SysUserMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * SysUserService
 *
 * @author byference
 * @since 2019-11-03
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * load user by username
     */
    public SysUser loadUserByUsername(String username) {
        Assert.hasLength(username, "用户名不允许为空");
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserNameEqualTo(username);
        final List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (CollectionUtils.isNotEmpty(sysUsers)) {
            return sysUsers.get(0);
        }
        return null;
    }

}
