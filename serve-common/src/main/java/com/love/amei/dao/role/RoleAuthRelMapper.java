package com.love.amei.dao.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.love.amei.dto.role.RoleAuthDto;
import com.love.amei.model.role.RoleAuthRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleAuthRelMapper extends BaseMapper<RoleAuthRel> {

    /**
     * 根据角色ID查询权限
     * @param roleId
     * @return
     */
    List<RoleAuthDto> getAuthByRoleId(@Param("roleId") String roleId);
}