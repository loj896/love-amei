package com.love.amei.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.role.AddRoleAuthDto;
import com.love.amei.dto.role.AddRoleDto;
import com.love.amei.dto.role.RoleAuthDto;
import com.love.amei.service.role.RoleAuthService;
import com.love.amei.service.role.RoleService;
import com.love.amei.util.CommonResult;
import com.love.amei.util.Rest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-01 16:46
 *           '::::::::::::'           @description
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
@Api(tags = "角色接口", description = "角色管理")
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAuthService roleAuthService;

    @ApiOperation(value = "添加角色")
    @PostMapping("/addRole")
    public CommonResult addRole(@RequestBody @Validated List<AddRoleDto> roleDtoList){
        boolean addResult = roleService.addRole(roleDtoList);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "添加角色权限")
    @PostMapping("/addRoleAuth")
    public CommonResult addRoleAuth(@RequestBody @Validated List<AddRoleAuthDto> roleAuthDtoList){
        boolean addResult = roleAuthService.addRoleAuth(roleAuthDtoList);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "根据角色Id查询权限")
    @PostMapping("/getAuthByRoleId")
    public CommonResult getAuthByRoleId(@RequestBody @Validated String roleId){
        List<RoleAuthDto> roleAuthDtoList = roleAuthService.getAuthByRoleId(roleId);
        if(!CollectionUtils.isEmpty(roleAuthDtoList)){
            return Rest.successWithData(roleAuthDtoList);
        }
        return Rest.fail("未查询到权限信息");
    }


}
