package com.love.amei.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.love.amei.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}