package com.mayday.model;

/**
 * 用户 -- >角色关系表
 */
public class URModel {

    private static final long serialVersionUID = 1L;

    private Long uid;  //用户id

    private Long rid;  //角色id

    public URModel() {
    }

    public URModel(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "URModel{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
