package com.love.amei.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.love.amei.dao.user.UserMapper;
import com.love.amei.dto.user.UserAuthDto;
import com.love.amei.model.user.User;
import com.love.amei.service.user.UserDaoService;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-26 15:44
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
public class UserDaoServiceImpl extends ServiceImpl<UserMapper, User> implements UserDaoService {

    @Override
    public List<UserAuthDto> getUserAuth(String userId) {
        return this.baseMapper.getUserAuth(userId);
    }
}
