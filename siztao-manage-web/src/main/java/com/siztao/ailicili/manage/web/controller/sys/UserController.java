package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.entity.sys.Role;
import com.siztao.ailicili.service.manage.entity.sys.User;
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
    @RequestMapping(value = "/addView",method = RequestMethod.GET)
    public String addView(){
        return PAGE_VIEW+"/add";
    }
    @RequestMapping(value = "/editView",method = RequestMethod.GET)
    public String editView(Integer  appId){
        return PAGE_VIEW+"/edit";
    }

	@RequestMapping("/applist")
    @ResponseBody
	public AjaxResult   applist(){
	    Integer userid = getUser().getId();
	    return AjaxResult.ok().put("appList",applicationService.selectAppListByUID(userid));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult list(@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
                           @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
                           @RequestParam(required = false, defaultValue = "", value = "search") String search,
                           @RequestParam(required = false, value = "sort") String sort,
                           @RequestParam(required = false, value = "order") String order){
        List<User> list = userService.selectList(null);
        return AjaxResult.ok("查询成功").put("rows",list).put("total",list.size());
    }
    @RequestMapping("/info")
    public AjaxResult info(){
	    return AjaxResult.ok().put("user",getUser());
    }

}
