package com.love.amei.feign.fallback;

import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.dto.user.AddUserRoleDto;
import com.love.amei.dto.user.LoginDto;
import com.love.amei.feign.SysFeignService;
import com.love.amei.util.CommonResult;
import com.love.amei.util.Rest;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-25 9:42
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
@Component
public class SysFeignServiceFallImpl implements SysFeignService {

    @Override
    public String hello(String name) {
        return "hello "+ name+" this is serve-auth , request error";
    }

    @Override
    public CommonResult getUser(LoginDto loginDto) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult addAuth(List<AddAuthDto> authDtoList) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getUserAuth(String userId) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult addUserRole(List<AddUserRoleDto> userRoleDtoList) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getUserRole(String userId) {
        return Rest.fail("查询失败，网路异常");
    }
}
