package com.a7z.sevenzgame.controller.show;


import com.a7z.sevenzgame.entity.pojo.Cart;
import com.a7z.sevenzgame.entity.pojo.CartList;
import com.a7z.sevenzgame.entity.vo.get.GameDetailGet;
import com.a7z.sevenzgame.entity.vo.get.GameSimpleGet;
import com.a7z.sevenzgame.service.*;
import com.a7z.sevenzgame.utils.DateKit;
import com.a7z.sevenzgame.utils.RedisUtil;
import com.a7z.sevenzgame.utils.UUID;
import com.a7z.sevenzgame.utils.UploadUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author lq
 * @create 2020/3/4-16:39
 */
@Controller
public class ShowController {
    @Autowired
    CompilationService compilationService;
    @Autowired
    GamesService gamesService;
    @Autowired
    TagsService tagsService;
    @Autowired
    CompanyService companyService;
    @Autowired
    TradeService tradeService;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/classes/{name}", method = RequestMethod.GET)
    public ModelAndView classes(@PathVariable("name") String name, ModelAndView modelAndView, HttpServletRequest request) {
        int tagId = tagsService.findTagId(name);
        List<GameSimpleGet> list = gamesService.findGameSimplesByTag(name);


        modelAndView.addObject("identity", chargeIdentity());
        modelAndView.addObject("monthTop", gamesService.findGameMonthTop());
        modelAndView.addObject("tagBg", tagId + ".jpg");
        modelAndView.addObject("type", name);
        modelAndView.addObject("list", list);
        modelAndView.setViewName("show/class");
        return modelAndView;

    }


    @RequestMapping(value = "/companies/{name}", method = RequestMethod.GET)
    public ModelAndView company(@PathVariable("name") String name, ModelAndView modelAndView, HttpServletRequest request) {
        int cid;
        try {
            cid = companyService.findId(name);
        } catch (Exception e) {
            modelAndView.setViewName("error/404");
            return modelAndView;
        }


        modelAndView.addObject("identity", chargeIdentity());
        modelAndView.addObject("companyGames", companyService.findGameComList(cid));
        modelAndView.addObject("companyInfo", companyService.findOne(cid));
        modelAndView.setViewName("show/company");
        return modelAndView;
    }


    @RequestMapping(value = "/games/{gid}", method = RequestMethod.GET)
    public ModelAndView game(@PathVariable("gid") int gid, ModelAndView modelAndView, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Cookie[] cookies = request.getCookies();
        String webId = UUID.UU32();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("7zGameId")) {
                webId = cookie.getValue();
            }
        }
        String cartHas = "添加购物车";
        Object principal = subject.getPrincipal();
        if (principal != null) {
            if (redisUtil.get("cart" + principal) != null) {
                CartList cartList = (CartList) redisUtil.get("cart" + principal);
                for (Cart cart : cartList.getList()) {
                    if (cart.getGid() == gid) {
                        cartHas = "已添加";
                        break;
                    }
                }
            }
        } else {
            if (redisUtil.get("cart" + webId) != null) {
                CartList cartList = (CartList) redisUtil.get("cart" + webId);
                for (Cart cart : cartList.getList()) {
                    if (cart.getGid() == gid) {
                        cartHas = "已添加";
                        break;
                    }
                }
            }
        }

        if (principal != null) {

            String userGame = tradeService.findUserGame(gid);
            System.out.println("userGame=="+userGame);
            if (userGame != null) {
                cartHas = "已购买";

            }
        }

        gamesService.addHot(gid, 1);
        GameDetailGet game = gamesService.findOne(gid);
        modelAndView.addObject("identity", chargeIdentity());
        modelAndView.addObject("cart", cartHas);
        modelAndView.addObject("game", game);
        modelAndView.addObject("similar", gamesService.findGameSimilar(game.getTags().get(0)));
        modelAndView.setViewName("show/game");
        return modelAndView;
    }

    @GetMapping(value = {"/","/index"})
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie myCookie = null;
        boolean has = false;

        if(cookies==null){
            myCookie = new Cookie("7zGameId", UUID.UU32());

        }else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("7zGameId")) {
                    has = true;
                    myCookie = new Cookie("7zGameId", cookie.getValue());
                    break;
                }
            }
            if (!has) {
                myCookie = new Cookie("7zGameId", UUID.UU32());
            }
        }



        myCookie.setMaxAge(36000);
        response.addCookie(myCookie);


        modelAndView.addObject("identity", chargeIdentity());
        modelAndView.addObject("gameNav", gamesService.findGameNav());
        modelAndView.addObject("gameRecommend", gamesService.findGameRecommend());
        modelAndView.addObject("gameDiscount", gamesService.findGameDiscount());
        modelAndView.addObject("gameUserRecommend", gamesService.findUserRecommend());
        modelAndView.addObject("compilation", compilationService.findList());
        modelAndView.addObject("gameMonthTop", gamesService.findGameMonthNewTop(DateKit.getCurrentUnixTime()));
        modelAndView.addObject("gameWeekTop", gamesService.findGameWeekTop());
        modelAndView.addObject("list", gamesService.findGameSimplesNewest());
        modelAndView.setViewName("show/index");
        return modelAndView;
    }

    @RequestMapping(value = "/compilations/{cid}", method = RequestMethod.GET)
    public ModelAndView compilation(@PathVariable("cid") int cid, ModelAndView modelAndView, HttpServletRequest request) {

        modelAndView.addObject("identity", chargeIdentity());
        modelAndView.addObject("compilation", compilationService.findGameList(cid));
        modelAndView.setViewName("show/compilation");
        return modelAndView;
    }

    @RequestMapping(value = "/users/{uid}", method = RequestMethod.GET)
    public ModelAndView user(@PathVariable("uid") int uid, ModelAndView modelAndView, HttpServletRequest request) {

        modelAndView.addObject("identity", chargeIdentity());
        modelAndView.setViewName("show/user");
        return modelAndView;
    }

    @GetMapping("/download")
    public void downLoad(String gameName, HttpServletResponse response) throws Exception {
        System.out.println("======");

//         File f = new File("C://1" + File.separator + gameName + ".txt");//本地
       File f = new File(File.separator +"www"+ File.separator +"game7z" + File.separator + gameName + ".txt");//在线
        f.setWritable(true, false);
        if (!f.exists()) {
            f.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(f);
        String text = "欢迎来到7zGame！！本系统为实战项目一切商品皆为虚拟货物\r\n" + "" +
                "您的商品为:" + gameName;
        outputStream.write(text.getBytes("UTF-8"));
        outputStream.close();


        String fileName = f.getName();
        fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");


        response.reset(); // 非常重要
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }

    private String chargeIdentity() {
        Subject subject = SecurityUtils.getSubject();
        Object uid = subject.getPrincipal();
        if (uid != null) {
            return "个人中心";
        } else {
            return "请登录";
        }
    }


}
