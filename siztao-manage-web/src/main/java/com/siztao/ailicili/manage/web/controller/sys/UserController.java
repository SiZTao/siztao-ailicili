package com.siztao.ailicili.manage.web.controller.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.entity.sys.User;
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
@RequestMapping("/manage/user")
public class UserController extends AbstractController{

    private static final String PAGE_VIEW= "manage/sys/user/";

    @Autowired
    private ApplicationService  applicationService;
	@Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String page(){
        return PAGE_VIEW+"/list";
    }

	@RequestMapping("/applist")
    @ResponseBody
	public AjaxResult   applist(){
	    Integer userid = getUser().getId();
	    return AjaxResult.ok().put("appList",applicationService.selectAppListByUID(userid));
    }

    /**
     * 添加用户数据
     * @param
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insert(@RequestBody User   user){
        if (user.getId()==null){
            userService.insert(user);
            return AjaxResult.ok("添加成功");
        }else {
            userService.updateById(user);
            return AjaxResult.ok("更新成功");
        }

    }

    /**
     * 编辑用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/editView",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult editView(@RequestParam("userId") Integer  userId){
        User user = userService.selectById(userId);
        return AjaxResult.ok("查询数据").put("user",user);
    }

    /**
     * 用户数据列表
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
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        Page<User>  page = new Page<User>(pageNumber,pageSize);
        Page<User> result = userService.selectPage(page,wrapper);
        //  List<Dept> list = deptService.selectList(null);
        return AjaxResult.ok("查询成功").put("rows",result.getRecords()).put("total",result.getTotal());
    }


    @RequestMapping("/info")
    public AjaxResult info(){
	    return AjaxResult.ok().put("user",getUser());
    }

}
