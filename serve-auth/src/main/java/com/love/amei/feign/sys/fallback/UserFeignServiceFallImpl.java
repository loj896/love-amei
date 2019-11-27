package com.love.amei.feign.sys.fallback;

import com.love.amei.dto.user.LoginDto;
import com.love.amei.feign.sys.UserFeignService;
import com.love.amei.util.CommonResult;
import com.love.amei.util.Rest;
import org.springframework.stereotype.Component;

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
public class UserFeignServiceFallImpl implements UserFeignService {

    @Override
    public String hello(String name) {
        return "hello "+ name+" this is serve-auth , request error";
    }

    @Override
    public CommonResult getUser(LoginDto loginDto) {
        return Rest.fail("查询失败，网路异常");
    }
}
