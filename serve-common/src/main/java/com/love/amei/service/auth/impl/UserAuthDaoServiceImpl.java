package com.love.amei.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.love.amei.dao.auth.UserAuthRelMapper;
import com.love.amei.dto.auth.UserAuthDto;
import com.love.amei.model.auth.UserAuthRel;
import com.love.amei.service.auth.UserAuthDaoService;
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
public class UserAuthDaoServiceImpl extends ServiceImpl<UserAuthRelMapper, UserAuthRel> implements UserAuthDaoService {

    @Override
    public List<UserAuthDto> getUserAuth(String userId) {
        return this.baseMapper.getUserAuth(userId);
    }
}
