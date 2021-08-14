package com.cloudalibaba.auth.mybatis.po;

import lombok.Data;

@Data
public class UserInfo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 角色
     */
    private String role;

    /**
     * 是否删除
     */
    private Boolean deleted;
}