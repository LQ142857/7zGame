package com.a7z.sevenzgame.controller;

import com.a7z.sevenzgame.entity.vo.ResultUploadImg;
import com.a7z.sevenzgame.service.ImageService;
import com.a7z.sevenzgame.utils.UUID;
import com.a7z.sevenzgame.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 公共controller
 * 验证码
 * 图片上传（有问题需要修改，username后面要改成管理者的id）
 *
 * @author lq
 * @create 2020/3/14-00:54
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    ImageService imageService;

    /**
     * 上传图片
     *
     * @return
     */
    @RequestMapping("/uploadImg")
    @ResponseBody
    public ResultUploadImg uploadImg(MultipartFile file) {
        ResultUploadImg json = new ResultUploadImg();
        String name = file.getOriginalFilename();
        if (file.isEmpty()) {
            json.setCode(ResultUploadImg.WRONG);
            json.setExplain("上传文件为空");
            return json;
        }
        String format = name.substring(name.lastIndexOf(".")).toLowerCase();
        String fileName = UUID.UU32();
        String real = UploadUtil.getUploadFilePath();
        String srcName = fileName + format;
        String filePath = "/upload/uploadImg/";

        File dest = new File(real + filePath + fileName + format);
        try {
            file.transferTo(dest);//将改文件上传至服务器的dest文件中
            json.setCode(ResultUploadImg.SUCCESS);
            json.setExplain("上传成功");
            json.setImageName(srcName);
            json.setText("     <li class=\"col-xs-4 col-sm-3 col-md-2\">\n" +
                    "                                        <figure>\n" +
                    "                                            <img class=\"username UImg\" src=\""+"/upload/uploadImg/"+srcName+"\">\n" +
                    "                                            <figcaption>\n" +
                    "                                                <a class=\"viewImg btn btn-round btn-square btn-primary\" href=\"#!\"><i\n" +
                    "                                                        class=\"mdi mdi-eye\">查看</i></a>\n" +
                    "                                                <a class=\"btn btn-round btn-square btn-danger\" href=\"#!\"><i\n" +
                    "                                                        class=\"deleteImg mdi mdi-delete\">删除</i></a>\n" +
                    "                                            </figcaption>\n" +
                    "                                        </figure>\n" +
                    "                                    </li>");
            imageService.addImage("88888888",srcName);
            return json;
        } catch (IOException e) {
            json.setCode(ResultUploadImg.WRONG);
            json.setExplain("服务器出错");
            return json;
        }
    }

}
