package com.siztao.ailicili.manage.web.controller.sys;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.siztao.framework.utils.ShiroUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class IndexController {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private Producer producer;


    @RequestMapping("/index")
    public String   index(){
        return "index";
    }

    @RequestMapping("/welcome")
    public String   welcome(){
        return "welcome";
    }
    /**
     *  生成验证码
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        LOG.debug("验证码"+text);
        ImageIO.write(image, "jpg", out);
    }

}
