package com.mayday.model;

/**
 * 权限实体类
 */
public class PermissionModel {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String url;  //操作的URL
    private String name;  //操作的名称

    public PermissionModel(Long id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public PermissionModel() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserPermissionModel{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
