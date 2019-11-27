package com.love.amei.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.love.amei.dto.auth.UserAuthDto;
import com.love.amei.model.auth.UserAuthRel;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:12
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
public interface UserAuthDaoService extends IService<UserAuthRel> {

    /**
     * 根据用户ID查询用户权限
     * @param userId
     * @return
     */
    List<UserAuthDto> getUserAuth(String userId);
}
