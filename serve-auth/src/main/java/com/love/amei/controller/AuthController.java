package com.love.amei.controller;

import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.feign.SysFeignService;
import com.love.amei.util.CommonResult;
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
    private SysFeignService sysFeignService;

    @ApiOperation(value = "添加权限")
    @PostMapping("/addAuth")
    public CommonResult addAuth(@RequestBody @Validated List<AddAuthDto> authDtoList){
        return sysFeignService.addAuth(authDtoList);
    }

    @ApiOperation(value = "查询用户权限")
    @PostMapping("/getUserAuth")
    public CommonResult getUserAuth(@RequestBody @Validated String userId){
        return sysFeignService.getUserAuth(userId);
    }
}
