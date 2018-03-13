package com.siztao.ailicili.manage.web.controller.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.siztao.ailicili.service.manage.api.sys.PermissionService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Permission;
import com.siztao.framework.constants.GlobalConstants;
import com.siztao.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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

    private static final String PAGE_VIEW= "manage/sys/permission/";


    @Autowired
    private PermissionService   permissionService;

    @RequestMapping(method = RequestMethod.GET)
    public String page(){
        return PAGE_VIEW+"/list";
    }

    /**
     * 添加权限信息
     * @return
     */
    @RequestMapping(value = "/addView",method = RequestMethod.GET)
    public String addView(){
        return PAGE_VIEW+"/add";
    }

    /**
     * 添加或更新权限
     * @param permission
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insert(@RequestBody Permission permission){
        if (permission.getId()==null){
            permissionService.insert(permission);
            return AjaxResult.ok("添加成功");
        }else {
            permissionService.updateById(permission);
            return AjaxResult.ok("更新成功");
        }

    }
    /**
     * 编辑权限信息
     * @param permissionId
     * @return
     */
    @RequestMapping(value = "/editView",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult editView(@RequestParam("permissionId") Integer permissionId){
        Permission  permission  = permissionService.selectById(permissionId);
        return AjaxResult.ok().put("permission",permission);
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

    @RequestMapping("/list")
    @ResponseBody
    public List<Permission> list(@RequestParam(required = false)Integer appId){
        if(appId == null){
            appId = GlobalConstants.APPID;
        }
        return permissionService.selectList(new EntityWrapper<Permission>().eq("appid",appId));
    }
}
