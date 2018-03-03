package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Controller
@RequestMapping("/manage/application")
public class ApplicationController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值

    }
    private static final String APP_VIEW= "manage/sys/app/";

    @Autowired  private ApplicationService  applicationService;

    @RequestMapping("/index")
    @ResponseBody
    public List<Application> index(){
        return applicationService.selectList(null);
    }

    @RequestMapping(value = "/page")
    public String page(){
        return "index";
    }

    @RequestMapping(value = "/list")
    public String list(){
        return APP_VIEW+"list";
    }

    @RequestMapping(value = "/main")
    public String main(Model model)
    {
        model.addAttribute("user","admin");
        return "index";
    }
}
