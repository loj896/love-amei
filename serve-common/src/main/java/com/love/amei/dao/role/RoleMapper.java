package com.love.amei.dao.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.love.amei.model.role.Role;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface RoleMapper extends BaseMapper<Role> {

}