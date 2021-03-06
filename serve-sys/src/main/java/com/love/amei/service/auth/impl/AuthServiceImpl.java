package com.love.amei.service.auth.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.model.auth.Auth;
import com.love.amei.service.auth.AuthDaoService;
import com.love.amei.service.auth.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:26
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
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDaoService authDaoService;

    @Override
    public boolean addAuth(List<AddAuthDto> authDtoList) {
        if(CollectionUtils.isEmpty(authDtoList)){
            return false;
        }
        List<Auth> addList = new ArrayList<>();
        Auth auth = null;
        for (AddAuthDto authDto : authDtoList){
            auth = new Auth();
            BeanUtils.copyProperties(authDto, auth);
            auth.setAuthState(1);
            addList.add(auth);
        }
        return authDaoService.saveBatch(addList);
    }
}
