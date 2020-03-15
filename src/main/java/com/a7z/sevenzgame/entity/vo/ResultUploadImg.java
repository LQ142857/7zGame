package com.a7z.sevenzgame.entity.vo;

/**图片上传，返回给前端的json数据
 * @author lq
 * @create 2020/3/14-00:56
 */
public class ResultUploadImg {
    public final static Integer WRONG = 404;
    public final static Integer SUCCESS = 200;
    private Integer code;
    private String explain;
    private String imageName;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "ResultUploadImg{" +
                "code=" + code +
                ", explain='" + explain + '\'' +
                ", imageName='" + imageName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
