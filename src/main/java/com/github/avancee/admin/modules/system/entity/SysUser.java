package com.github.avancee.admin.modules.system.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * SysUser
 *
 * @author byference
 * @since 2019-11-03
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = -7852291356750769449L;

    /**
     * 主键ID
     */
    @Id
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