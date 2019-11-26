package com.love.amei.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.love.amei.model.user.User;
import com.love.amei.service.user.UserDaoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-26 21:50
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
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserDaoService userService;

    /**
     * 权限校验相关
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份认证相关
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**
         * 1. 从Token中获取输入的用户名密码
         * 2. 通过输入的用户名查询数据库得到密码
         * 3. 调用Authentication进行密码校验
         */

        //获取用户名密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        wrapper.eq("password", password);
        User user = userService.getOne(wrapper);
        if (user == null) {
            throw new UnknownAccountException();
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
