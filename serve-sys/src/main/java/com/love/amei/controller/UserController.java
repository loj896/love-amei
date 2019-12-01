package com.love.amei.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.user.AddUserRoleDto;
import com.love.amei.dto.user.LoginDto;
import com.love.amei.dto.user.UserAuthDto;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.model.user.User;
import com.love.amei.service.user.UserService;
import com.love.amei.util.CommonResult;
import com.love.amei.util.Rest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-22 17:07
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
@Api(tags = "用户接口", description = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello "+name+" this is serve-sys";
    }

    @ApiOperation(value = "根据用户名和密码查询用户信息")
    @PostMapping("/getUser")
    public CommonResult getUser(@RequestBody @Validated LoginDto loginDto){
        User user = userService.getUserByPwdAndName(loginDto);
        if(null != user){
            return Rest.successWithData(user);
        }
        return Rest.fail("未查询到用户信息");
    }

    @ApiOperation(value = "查询用户权限")
    @PostMapping("/getUserAuth")
    public CommonResult getUserAuth(@RequestBody @Validated String userId){
        List<UserAuthDto> authDtoList = userService.getUserAuth(userId);
        if(CollectionUtils.isEmpty(authDtoList)){
            return Rest.fail("未查询到用户权限信息");
        }
        return Rest.successWithData(authDtoList);
    }

    @ApiOperation(value = "新增用户角色")
    @PostMapping("/addUserRole")
    public CommonResult addUserRole(@RequestBody @Validated List<AddUserRoleDto> userRoleDtoList){
        boolean addResult = userService.addUserRole(userRoleDtoList);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "查询用户拥有的角色")
    @PostMapping("/getUserRole")
    public CommonResult getUserRole(@RequestBody @Validated String userId){
        List<UserRoleDto> userRoleDtoList = userService.getUserRole(userId);
        if(CollectionUtils.isEmpty(userRoleDtoList)){
            return Rest.fail("未查询到用户角色信息");
        }
        return Rest.successWithData(userRoleDtoList);
    }
}
