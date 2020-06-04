package com.a7z.sevenzgame.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lq
 * @create 2020/3/12-22:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameConfigure {
    private String gid;
    private String system;
    private String cpu;
    private String gpu;
    private String ram;
    private String rom;
    private int net;
    private String directx;

}
