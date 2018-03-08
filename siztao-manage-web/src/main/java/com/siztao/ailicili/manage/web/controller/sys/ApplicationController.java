package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.framework.cache.RedisCache;
import com.siztao.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import redis.clients.jedis.Jedis;

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


    private static final String APP_VIEW= "manage/sys/app/";

    @Autowired
    private ApplicationService  applicationService;
    @Autowired
    RedisCache  redisCache;


    @RequestMapping(method = RequestMethod.GET)
    public String page(){
        return APP_VIEW+"/list";
    }

    @RequestMapping(value = "/main")
    public String main(Model model) {
        model.addAttribute("user","admin");
        return "index";
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult list(@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
                           @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
                           @RequestParam(required = false, defaultValue = "", value = "search") String search,
                           @RequestParam(required = false, value = "sort") String sort,
                           @RequestParam(required = false, value = "order") String order){
        List<Application>   list = applicationService.selectList(null);
        redisCache.putListCache("applist",list);
        return AjaxResult.ok("查询成功").put("rows",list).put("total",list.size());
    }

    /**
     * 添加应用数据
     * @param application
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insert(Application   application){
        applicationService.insert(application);
        return AjaxResult.ok("添加成功");
    }


    /**
     * 删除应用数据
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(List<Integer>  ids){
        return AjaxResult.ok("删除成功");
    }

    /**
     * 更新应用数据
     * @param application
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(Application   application){
        return AjaxResult.ok("添加成功");
    }

    /**
     * 查询数据
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public AjaxResult   query(){
        return AjaxResult.ok("查询结果");
    }
}
