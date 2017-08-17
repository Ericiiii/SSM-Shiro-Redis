package com.mayday.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 用户角色实体类
 */
public class RoleModel {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;  //角色名称

    private String type;  //角色类型

    private List<PermissionModel> permissions = new LinkedList<PermissionModel>();  //role --> permission一对多处理
}
