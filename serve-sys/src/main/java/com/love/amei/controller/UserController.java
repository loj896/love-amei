package com.love.amei.controller;

import com.love.amei.dto.user.LoginDto;
import com.love.amei.model.user.User;
import com.love.amei.service.user.UserService;
import com.love.amei.util.CommonResult;
import com.love.amei.util.Rest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
}
