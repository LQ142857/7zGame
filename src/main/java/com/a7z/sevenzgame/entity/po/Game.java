package com.a7z.sevenzgame.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lq
 * @create 2020/3/12-22:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private int gid;
    private String name;
    private int time;
    private int company;
    private String companyName;
    private String cost;
    private String price;
    private String discount;
    private String describes;
    private String cover;
    private String videourl;
    private String videoBg;
    private String grade;
    private String state;
    private String bg;
    private String detail;
    private String configuration;
    private String language;
    private int hot;


}
