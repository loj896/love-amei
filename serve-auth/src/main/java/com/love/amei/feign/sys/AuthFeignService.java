package com.love.amei.feign.sys;

import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:43
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
@FeignClient(value = "serve-sys")
public interface AuthFeignService {

    /**
     * 添加权限
     * @param authDtoList
     * @return
     */
    @PostMapping("/sys/auth/addAuth")
    CommonResult addAuth(@RequestBody @Validated List<AddAuthDto> authDtoList);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @PostMapping("/sys/auth/getUserAuth")
    CommonResult getUserAuth(@RequestBody @Validated String userId);
}
