package com.intecsec.mall.user.enums;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-16 21:35
 **/
public enum RoleEnum {
    COMMON(1, "普通用户"),
    ADMIN(2, "管理员"),
    ;
    private int role;
    private String roleName;

    RoleEnum(int role, String roleName) {
        this.role = role;
        this.roleName = roleName;
    }

    public int getRole() {
        return role;
    }

    public String getRoleName() {
        return roleName;
    }

    public static boolean roleOf(int role) {
        for(RoleEnum roleEnum : RoleEnum.values()) {
            if(roleEnum.getRole() == role) {
                return true;
            }
        }
        return false;
    }
}
