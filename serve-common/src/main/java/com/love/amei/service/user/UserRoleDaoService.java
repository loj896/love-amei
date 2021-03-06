package com.love.amei.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.model.user.UserRoleRel;

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
public interface UserRoleDaoService extends IService<UserRoleRel> {

    /**
     * 根据用户ID查询用户拥有的角色
     * @param userId
     * @return
     */
    List<UserRoleDto> getUserRole(String userId);
}
