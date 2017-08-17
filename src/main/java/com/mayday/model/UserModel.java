package com.mayday.model;

import java.util.Date;

/**
 * 用户实体类
 */
public class UserModel {

    private static final long serialVersionUID = 1L;

    public static final Long status_0 = new Long(0); //0:禁止登录
    public static final Long status_1 = new Long(1); //1:有效

    private Long id;
    private String userName;  //用户名称
    private String email;  //用户邮箱
    private transient String password;  //登录密码
    private Date createTime;  //创建时间
    private Date lastLoginTime;  //最后登录时间
    private Long status; //状态 ： 1.有效 0.禁止登录

    public UserModel(Long id, String userName, String email, String password, Date createTime, Date lastLoginTime, Long status) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
    }

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public static Long getStatus_0() {
        return status_0;
    }

    public static Long getStatus_1() {
        return status_1;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                '}';
    }
}
