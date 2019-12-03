package com.love.amei.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.love.amei.dto.role.RoleAuthDto;
import com.love.amei.dto.user.LoginDto;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.feign.SysFeignService;
import com.love.amei.model.user.User;
import com.love.amei.util.BeanConvert;
import com.love.amei.util.CommonResult;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SysFeignService sysFeignService;

    /**
     * 权限校验相关
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();

        //根据用户ID查询用户角色
        CommonResult rest = sysFeignService.getUserRole(user.getUserId());
        List<UserRoleDto> userRoleDtoList = BeanConvert.listConvert((List<UserRoleDto>)rest.getData(),UserRoleDto.class);
        if(!CollectionUtils.isEmpty(userRoleDtoList)){
            List<RoleAuthDto> roleAuthDtoList = null;
            for (UserRoleDto roleDto : userRoleDtoList){
                authorizationInfo.addRole(roleDto.getRoleId());
                //根据角色ID查询权限
                rest = sysFeignService.getAuthByRoleId(roleDto.getRoleId());
                roleAuthDtoList = BeanConvert.listConvert((List<RoleAuthDto>)rest.getData(), RoleAuthDto.class);
                if(!CollectionUtils.isEmpty(roleAuthDtoList)){
                    for (RoleAuthDto authDto : roleAuthDtoList){
                        authorizationInfo.addStringPermission(authDto.getAuthCode());
                    }
                }
            }
        }
        return authorizationInfo;
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

        LoginDto loginDto = new LoginDto();
        loginDto.setUserName(username);
        loginDto.setPassword(password);
        CommonResult rest = sysFeignService.getUser(loginDto);
        User user = BeanConvert.beanConvert(rest.getData(), User.class);

        if (user == null) {
            throw new UnknownAccountException();
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
