package com.love.amei.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.love.amei.dao.user.UserRoleRelMapper;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.model.user.UserRoleRel;
import com.love.amei.service.user.UserRoleDaoService;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:13
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
public class UserRoleDaoServiceImpl extends ServiceImpl<UserRoleRelMapper, UserRoleRel> implements UserRoleDaoService {

    @Override
    public List<UserRoleDto> getUserAuth(String userId) {
        return this.baseMapper.getUserAuth(userId);
    }
}
