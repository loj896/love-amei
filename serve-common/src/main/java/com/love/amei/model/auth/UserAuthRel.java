package com.love.amei.model.auth;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user_auth_rel")
public class UserAuthRel {

    @TableId
    private String userAuthId;

    private String userId;

    private String authId;

    private Integer relState;

    public String getUserAuthId() {
        return userAuthId;
    }

    public void setUserAuthId(String userAuthId) {
        this.userAuthId = userAuthId == null ? null : userAuthId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId == null ? null : authId.trim();
    }

    public Integer getRelState() {
        return relState;
    }

    public void setRelState(Integer relState) {
        this.relState = relState;
    }
}