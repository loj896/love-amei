package com.love.amei.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.love.amei.dto.user.LoginDto;
import com.love.amei.model.user.User;
import com.love.amei.service.user.UserDaoService;
import com.love.amei.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-26 15:50
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
public class UserServiceImpl implements UserService {

    @Resource
    private UserDaoService userDaoService;

    @Override
    public User getUserByPwdAndName(LoginDto loginDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", loginDto.getUserName());
        wrapper.eq("password", loginDto.getPassword());
        return userDaoService.getOne(wrapper);
    }
}
