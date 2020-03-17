package com.a7z.sevenzgame.entity.po;

/**
 * @author lq
 * @create 2020/3/15-21:52
 */
public class Perm {
    private String permId;
    private String name;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Perm{" +
                "permId='" + permId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
