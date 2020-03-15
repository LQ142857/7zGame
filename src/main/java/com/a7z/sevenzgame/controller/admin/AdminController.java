package com.a7z.sevenzgame.controller.admin;

import com.a7z.sevenzgame.entity.vo.GameCommit;
import com.a7z.sevenzgame.utils.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lq
 * @create 2020/3/13-09:27
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/submitGame")
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.addObject("id", UUID.UU32());
        model.setViewName("/Admin/submitGame");
        return model ;
    }



}
