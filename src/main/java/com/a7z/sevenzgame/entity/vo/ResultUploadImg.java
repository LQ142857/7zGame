package com.a7z.sevenzgame.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**图片上传，返回给前端的json数据
 * @author lq
 * @create 2020/3/14-00:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultUploadImg {
    public final static Integer WRONG = 404;
    public final static Integer SUCCESS = 200;
    private Integer code;
    private String explain;
    private String imageName;
    private String text;


}
