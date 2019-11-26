package com.love.amei.controller;

import com.love.amei.dto.user.LoginDto;
import com.love.amei.feign.UserFeignService;
import com.love.amei.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-22 17:18
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
@RequestMapping("/auth/user")
public class UserController {

    @Resource
    private UserFeignService userFeignService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        //return userFeignService.hello(name);
        return "hello "+name+" this is serve-auth";
    }

    @ApiOperation(value = "根据用户名和密码查询用户信息")
    @PostMapping("/getUser")
    public CommonResult getUser(@RequestBody @Validated LoginDto loginDto){
        return userFeignService.getUser(loginDto);
    }
}
