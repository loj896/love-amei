package com.love.amei.service.auth.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.model.user.UserRoleRel;
import com.love.amei.service.user.UserRoleDaoService;
import com.love.amei.service.auth.UserAuthService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:35
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
public class UserAuthServiceImpl implements UserAuthService {

    @Resource
    private UserRoleDaoService userAuthDaoService;

    @Override
    public boolean addUserAuth(List<String> authIds, String userId) {
        if(CollectionUtils.isEmpty(authIds) || StringUtils.isEmpty(userId)){
            return false;
        }
        List<UserRoleRel> relList = new ArrayList<>();
        UserRoleRel userAuthRel = null;
        for (String auhtId : authIds){
            userAuthRel = new UserRoleRel();
            userAuthRel.setRelState(1);
            //userAuthRel.setAuthId(auhtId);
            userAuthRel.setUserId(userId);
            relList.add(userAuthRel);
        }
        return userAuthDaoService.saveBatch(relList);
    }

    @Override
    public List<UserRoleDto> getUserAuth(String userId) {
        return userAuthDaoService.getUserAuth(userId);
    }
}
