package com.github.avancee.admin.modules.system.vo;

import com.github.avancee.admin.modules.system.entity.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SysUserVO
 *
 * @see SysUser
 * @author byference
 * @since 2019-11-04
 */
@Data
public class SysUserVO implements Serializable {

    private static final long serialVersionUID = -7888983370662950830L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

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
     * 邮箱
     */
    private String email;

    /**
     * 简介
     */
    private String userProfile;

    /**
     * 用户状态：0禁用，1启用，2锁定
     */
    private Integer userState;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private Integer modifyUser;

    /**
     * 修改时间
     */
    private Date modifyDate;


}
