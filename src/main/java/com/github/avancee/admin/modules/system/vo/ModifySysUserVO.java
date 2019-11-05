package com.github.avancee.admin.modules.system.vo;

import com.github.avancee.admin.modules.system.entity.SysUser;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ModifySysUserVO
 *
 * @see SysUser
 * @author byference
 * @since 2019-11-04
 */
@Data
public class ModifySysUserVO implements Serializable {

    private static final long serialVersionUID = -5331244046928277068L;

    /**
     * 主键ID
     */
    @NotNull(message = "用户ID不能为空")
    private Integer id;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String userProfile;

}
