package com.siztao.ailicili.manage.web.controller.sys;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.siztao.framework.model.AjaxResult;
import com.siztao.framework.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @项目名称: siztao-ailicili
 * @模块名称: 后台管理系统
 * @类名称:   SSOLoginController
 * @类描述:   后台登录控制器
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-04 21:18
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-04 21:18
 * @email: 982637685@qq.com
 * @version:
 **/
@Controller
public class SSOLoginController extends AbstractController {

    /**
     * 系统登录
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login",method = RequestMethod.POST)
    public AjaxResult login(String   account, String password, String captcha) throws IOException{
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if(null == kaptcha)
            return AjaxResult.error("验证码已失效");
        if(!captcha.equalsIgnoreCase(kaptcha)){
            return AjaxResult.error("验证码错误");
        }
        try{
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            System.out.printf(password);
            UsernamePasswordToken token = new UsernamePasswordToken(account,password);
            subject.login(token);
        }catch (UnknownAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return AjaxResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (AuthenticationException e) {
            return AjaxResult.error("账户验证失败");
        }
        return AjaxResult.ok();
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:/";
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
