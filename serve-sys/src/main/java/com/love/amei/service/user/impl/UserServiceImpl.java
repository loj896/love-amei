package com.love.amei.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.user.AddUserRoleDto;
import com.love.amei.dto.user.LoginDto;
import com.love.amei.dto.user.UserAuthDto;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.model.user.User;
import com.love.amei.model.user.UserRoleRel;
import com.love.amei.service.user.UserDaoService;
import com.love.amei.service.user.UserRoleDaoService;
import com.love.amei.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private UserRoleDaoService userRoleDaoService;

    @Override
    public User getUserByPwdAndName(LoginDto loginDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", loginDto.getUserName());
        wrapper.eq("password", loginDto.getPassword());
        return userDaoService.getOne(wrapper);
    }

    @Override
    public boolean addUserRole(List<AddUserRoleDto> userRoleDtoList) {
        if(CollectionUtils.isEmpty(userRoleDtoList)){
            return false;
        }
        List<UserRoleRel> relList = new ArrayList<>();
        UserRoleRel rel = null;
        for (AddUserRoleDto userRoleRel : userRoleDtoList){
            rel = new UserRoleRel();
            BeanUtils.copyProperties(userRoleRel, rel);
            rel.setRelState(1);
            relList.add(rel);
        }
        return userRoleDaoService.saveBatch(relList);
    }

    @Override
    public List<UserRoleDto> getUserRole(String userId) {
        return userRoleDaoService.getUserRole(userId);
    }

    @Override
    public List<UserAuthDto> getUserAuth(String userId) {
        return userDaoService.getUserAuth(userId);
    }
}
