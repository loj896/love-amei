package com.love.amei.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.love.amei.dto.auth.UserAuthDto;
import com.love.amei.model.auth.UserAuthRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAuthRelMapper extends BaseMapper<UserAuthRel> {

    /**
     * 根据用户ID查询用户权限
     * @param userId
     * @return
     */
    List<UserAuthDto> getUserAuth(@Param("userId") String userId);
}