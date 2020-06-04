package com.a7z.sevenzgame.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 提交的游戏信息(除图片)
 *
 * @author lq
 * @create 2020/3/12-22:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCommit {
    private String name;
    private String company;
    private String price;
    private String discount;
    private String tag;
    private String describe;
    private String cover;
    private String videourl;
    private int net;
    private String system;
    private String cpu;
    private String gpu;
    private String ram;
    private String rom;
    private String directx;


}
