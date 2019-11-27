package com.love.amei.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.dto.auth.UserAuthDto;
import com.love.amei.service.auth.AuthService;
import com.love.amei.service.auth.UserAuthService;
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
 *             ..:::::::::::'         @date 2019-11-27 10:46
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
@Api(tags = "权限接口", description = "权限管理")
@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserAuthService userAuthService;

    @ApiOperation(value = "添加权限")
    @PostMapping("/addAuth")
    public CommonResult addAuth(@RequestBody @Validated List<AddAuthDto> authDtoList){
        boolean addResult = authService.addAuth(authDtoList);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "查询用户权限")
    @PostMapping("/getUserAuth")
    public CommonResult getUserAuth(@RequestBody @Validated String userId){
        List<UserAuthDto> authDtoList = userAuthService.getUserAuth(userId);
        if(CollectionUtils.isEmpty(authDtoList)){
            return Rest.fail("未查询到用户权限信息");
        }
        return Rest.successWithData(authDtoList);
    }
}
