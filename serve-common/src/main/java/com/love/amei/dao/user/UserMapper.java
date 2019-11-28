package com.love.amei.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.love.amei.dto.user.UserAuthDto;
import com.love.amei.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    List<UserAuthDto> getUserAuth(@Param("userId") String userId);
}