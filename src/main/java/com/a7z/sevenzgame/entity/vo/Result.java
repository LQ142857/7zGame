package com.a7z.sevenzgame.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回的结果
 *
 * @author lq
 * @create 2020/3/18-11:14
 */
@ApiModel("ResultAdmin：返回的json")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    public final static int SUCCESS=200;
    public final static int NOTFIND=404;
    public final static int FORBIDDEN=403;
    public final static int ERROR=500;


    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("附加信息")
    private String msg;


}
