package com.siztao.ailicili.manage.web.controller.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.framework.cache.RedisCache;
import com.siztao.framework.model.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  应用控制器
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Controller
@RequestMapping("/manage/application")
public class ApplicationController extends AbstractController{
    private static Logger LOG = LoggerFactory.getLogger(ApplicationController.class);

    private static final String APP_VIEW= "manage/sys/app/";

    @Autowired
    private ApplicationService  applicationService;


    /**
     * 进入应用管理界面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String page(){
        return APP_VIEW+"/list";
    }

    @RequestMapping(value = "/addView",method = RequestMethod.GET)
    public String addView(ModelAndView modelAndView,Model   model){
        model.addAttribute("appId",1);
        LOG.info("权限管理系统:应用管理AppId{}","addView");
        return APP_VIEW+"/add";
    }

    /**
     * 应用信息编辑
     * @param appId
     * @return
     */
    @RequestMapping(value = "/editView",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult editView(Integer  appId){
        LOG.info("权限管理系统:应用管理AppId{}","editView"+appId);
        Application application = applicationService.selectById(appId);
        return AjaxResult.ok("查询数据").put("app",application);
    }

    /**
     * 应用数据列表
     * @param pageNumber
     * @param pageSize
     * @param search
     * @param sort
     * @param sortOrder
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult list(@RequestParam(required = false, defaultValue = "0", value = "pageNumber") int pageNumber,
                           @RequestParam(required = false, defaultValue = "10", value = "pageSize") int pageSize,
                           @RequestParam(required = false, defaultValue = "", value = "search") String search,
                           @RequestParam(required = false, value = "sort") String sort,
                           @RequestParam(required = false, value = "sortOrder") String sortOrder){
        EntityWrapper<Application> wrapper = new EntityWrapper<>();
        Page<Application>  page = new Page<Application>(pageNumber,pageSize);
        Page<Application> result = applicationService.selectPage(page,wrapper);
        //  List<Dept> list = deptService.selectList(null);
        return AjaxResult.ok("查询成功").put("rows",result.getRecords()).put("total",result.getTotal());
    }

    /**
     * 添加应用数据
     * @param application
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insert(@RequestBody Application   application){
        if (application.getId()==null){
            applicationService.insert(application);
            return AjaxResult.ok("添加成功");
        }else {
            applicationService.updateById(application);
            return AjaxResult.ok("更新成功");
        }

    }


    /**
     * 删除应用数据
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(@RequestParam("appId") Integer appId){
        boolean flag = applicationService.deleteById(appId);
        return AjaxResult.ok("删除成功");
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
