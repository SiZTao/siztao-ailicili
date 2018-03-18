package com.siztao.ailicili.manage.web.controller.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.siztao.ailicili.service.manage.api.sys.PermissionService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.ailicili.service.manage.entity.sys.Permission;
import com.siztao.framework.constants.GlobalConstants;
import com.siztao.framework.model.AjaxResult;
import com.siztao.framework.model.ZtreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  权限管理
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


    /**
     * 权限数据管理
     * @param appId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Permission> list(@RequestParam(required = false)Integer appId,@RequestParam Map<String,Object> map){
        Integer userId = getUserId();       //取得用户ID
        map.put("userid",userId);
        if(appId == null){
            appId = GlobalConstants.APPID;
            map.put("appid",appId);
        }
                                            //查询用户权限
        return permissionService.listPermissionWithUID(map);
    }

    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    @ResponseBody
    public  List<ZtreeVo> getDeptTree(@RequestParam(required = false, defaultValue = "false", value = "showTopParent")Boolean showTopParent,
                                      @RequestParam(required = false, defaultValue = "true", value = "open") Boolean open,
                                      @RequestParam(required = false, defaultValue = "true", value = "enable")  Boolean enable,
                                      @RequestParam(required = false)Integer appId,
                                      @RequestParam Map<String,Object> map){
        if(appId == null){
            appId = GlobalConstants.APPID;
        }
        List<Permission>    vos = new ArrayList<Permission>();
        if(getUserId()==0){
                vos = permissionService.selectList(new EntityWrapper<Permission>().eq("appid",appId));
        }else {
                map.put("userid",getUserId());
                map.put("appid",appId);
                vos= permissionService.listPermissionWithUID(map);
        }
        List<ZtreeVo> perTree = permissionService.selectPermissionWithZtree(showTopParent,vos);
        return perTree;
    }
}
