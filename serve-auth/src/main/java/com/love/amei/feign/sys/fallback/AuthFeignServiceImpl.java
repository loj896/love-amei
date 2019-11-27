package com.love.amei.feign.sys.fallback;

import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.feign.sys.AuthFeignService;
import com.love.amei.util.CommonResult;
import com.love.amei.util.Rest;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:45
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
@Service
public class AuthFeignServiceImpl implements AuthFeignService {

    @Override
    public CommonResult addAuth(List<AddAuthDto> authDtoList) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getUserAuth(String userId) {
        return Rest.fail("查询失败，网路异常");
    }
}
