package com.github.avancee.admin.modules.system.controller;

import com.github.avancee.admin.modules.system.service.SysUserService;
import com.github.avancee.admin.modules.system.vo.ModifySysUserVO;
import com.github.avancee.admin.util.RestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SysUserController
 *
 * @author byference
 * @since 2019-11-04
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    private final SysUserService sysUserService;


    @PostMapping("modify")
    public RestBody<String> modifySysUser(@Validated ModifySysUserVO modifySysUserVO) {
        sysUserService.modifySysUser(modifySysUserVO);
        return RestBody.ok();
    }

}
