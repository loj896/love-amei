package com.love.amei.service.auth;

import com.love.amei.dto.user.UserRoleDto;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:33
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
public interface UserAuthService {

    /**
     * 添加用户权限
     * @param authIds
     * @param userId
     * @return
     */
    boolean addUserAuth(List<String> authIds, String userId);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    List<UserRoleDto> getUserAuth(String userId);
}
