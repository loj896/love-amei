package com.love.amei.feign;

import com.love.amei.dto.auth.AddAuthDto;
import com.love.amei.dto.user.AddUserRoleDto;
import com.love.amei.dto.user.LoginDto;
import com.love.amei.feign.fallback.SysFeignServiceFallImpl;
import com.love.amei.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-25 9:25
 *           '::::::::::::'           @description Feign 服务通信，开启 hystrix 熔断器
 *             .::::::::::                      1、pom.xml 文件添加 Feign 依赖
 *        '::::::::::::::..                     2、启动类添加 @EnableFeignClients 注解
 *             ..::::::::::::.                  3、调用接口添加 @FeignClient 注解，value 指定已注册服务名称 ,
 *           ``::::::::::::::::                 4、方法和服务提供方参数、返回值一致，@RequestMapping 指定具体路径
 *            ::::``:::::::::'        .:::.     5、熔断处理：配置文件添加feign.hystrix.enabled=true @FeignClient 添加属性 fallback=实现类.class
 *           ::::'   ':::::'       .::::::::.      在实现的方法体中处理调用失败逻辑
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
@FeignClient(value = "serve-sys", fallback = SysFeignServiceFallImpl.class)
public interface SysFeignService {

    @GetMapping("/sys/user/hello/{name}")
    String hello(@PathVariable(name = "name") String name);

    /**
     * 根据用户名和登录密码查询用户信息
     * @param loginDto
     * @return
     */
    @PostMapping("/sys/user/getUser")
    CommonResult getUser(@RequestBody @Validated LoginDto loginDto);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @PostMapping("/sys/user/getUserAuth")
    CommonResult getUserAuth(@RequestBody @Validated String userId);

    /**
     * 新增用户角色
     * @param userRoleDtoList
     * @return
     */
    @PostMapping("/sys/user/addUserRole")
    CommonResult addUserRole(@RequestBody @Validated List<AddUserRoleDto> userRoleDtoList);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    @PostMapping("/sys/user/getUserRole")
    CommonResult getUserRole(@RequestBody @Validated String userId);

    /**
     * 添加权限
     * @param authDtoList
     * @return
     */
    @PostMapping("/sys/auth/addAuth")
    CommonResult addAuth(@RequestBody @Validated List<AddAuthDto> authDtoList);

    /**
     * 根据角色ID查询权限信息
     * @param roleId
     * @return
     */
    @PostMapping("/sys/role/getAuthByRoleId")
    CommonResult getAuthByRoleId(@RequestBody @Validated String roleId);

}
