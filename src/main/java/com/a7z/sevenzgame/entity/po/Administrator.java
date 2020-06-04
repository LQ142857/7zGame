package com.a7z.sevenzgame.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lq
 * @create 2020/3/15-21:49
 */
@ApiModel("管理员实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
    @ApiModelProperty("管理员id")
    private String adminId;
    @ApiModelProperty("管理员名字")
    private String name;
    @ApiModelProperty("管理员密码")
    private String password;
}
