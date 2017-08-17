package com.mayday.model;

/**
 * 角色和权限中间表
 * Role and Permission
 */
public class RPModel {

    private static final long serialVersionUID = 1L;

    private Long rid;  //角色ID
    private Long pid;  //权限ID

    public RPModel() {
    }

    public RPModel(Long rid, Long pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "UserRolePermissionModel{" +
                "rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}
