package com.github.avancee.admin.modules.system.service;

import com.github.avancee.admin.modules.system.entity.SysUser;
import com.github.avancee.admin.modules.system.mapper.SysUserMapper;
import com.github.avancee.admin.modules.system.vo.ModifySysUserVO;
import com.github.avancee.admin.util.PrincipalUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * SysUserService
 *
 * @author byference
 * @since 2019-11-03
 */
@Service
@RequiredArgsConstructor
public class SysUserService {

    private final SysUserMapper sysUserMapper;

    /**
     * modify SysUser information
     *
     * @param modifySysUserVO {@link ModifySysUserVO}
     * @return true if the modification is successful
     */
    public boolean modifySysUser(ModifySysUserVO modifySysUserVO) {

        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(modifySysUserVO, sysUser);
        sysUser.setModifyDate(new Date());
        sysUser.setModifyUser(PrincipalUtil.getCurrentUserId());
        return sysUserMapper.updateByPrimaryKeySelective(sysUser) > 0;
    }

    /**
     * load user by username
     */
    public SysUser loadUserByUsername(String username) {
        Assert.hasLength(username, "用户名不允许为空");

        Example sysUserExample = new Example(SysUser.class);
        sysUserExample.createCriteria().andEqualTo("userName", username);
        final List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (CollectionUtils.isNotEmpty(sysUsers)) {
            return sysUsers.get(0);
        }
        return null;
    }

}
