package com.love.amei.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.love.amei.dto.user.UserRoleDto;
import com.love.amei.model.user.UserRoleRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleRelMapper extends BaseMapper<UserRoleRel> {

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    List<UserRoleDto> getUserRole(@Param("userId") String userId);
}