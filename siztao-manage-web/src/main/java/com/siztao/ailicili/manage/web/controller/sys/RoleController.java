package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Controller
@RequestMapping("/manage/role")
public class RoleController {

	private static final String PAGE_VIEW= "manage/sys/role/";

	@Autowired  private UserService userService;

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
}
