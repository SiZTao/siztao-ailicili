package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private ApplicationService  applicationService;
	@Autowired
    private UserService userService;

	@RequestMapping("/applist")
    @ResponseBody
	public AjaxResult   applist(){
	    Integer userid = getUser().getId();
	    return AjaxResult.ok().put("appList",applicationService.selectAppListByUID(userid));
    }
    @RequestMapping("/info")
    public AjaxResult info(){
	    return AjaxResult.ok().put("user",getUser());
    }
}
