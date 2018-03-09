package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.PermissionService;
import com.siztao.ailicili.service.manage.entity.sys.Permission;
import com.siztao.framework.constants.GlobalConstants;
import com.siztao.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/manage/permission")
public class PermissionController extends AbstractController{

    private static final String PAGE_VIEW= "manage/sys/dept/";


    @Autowired
    private PermissionService   permissionService;

    @RequestMapping(method = RequestMethod.GET)
    public String page(){
        return PAGE_VIEW+"/list";
    }
    @RequestMapping(value = "/addView",method = RequestMethod.GET)
    public String addView(){
        return PAGE_VIEW+"/add";
    }
    @RequestMapping(value = "/editView",method = RequestMethod.GET)
    public String editView(Integer  appId){
        return PAGE_VIEW+"/edit";
    }
    /**
     * 用户菜单列表
     */
    @RequestMapping("/user")
    @ResponseBody
    public AjaxResult   user(@RequestParam(required = false)Integer appId){
        if(appId == null){
            appId = GlobalConstants.APPID;
        }
        List<Permission>    menuList = permissionService.getUserMenuList(getUserId(),appId);
        return AjaxResult.ok().put("menuList",menuList);
    }
}
