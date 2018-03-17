package com.siztao.ailicili.manage.web.controller.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siztao.ailicili.service.manage.api.sys.RoleService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Role;
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
@RequestMapping("/manage/role")
public class RoleController {

	private static final String PAGE_VIEW= "manage/sys/role/";

	@Autowired  private UserService userService;
	@Autowired	private RoleService	roleService;
	@RequestMapping(method = RequestMethod.GET)
	public String page(){
		return PAGE_VIEW+"/list";
	}

	@RequestMapping(value = "/editView",method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult editView(@RequestParam("roleId") Integer  roleId){
		Role role = roleService.selectById(roleId);
		return AjaxResult.ok("查询数据").put("role",role);
	}
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult list(@RequestParam(required = false, defaultValue = "0", value = "pageNumber") int pageNumber,
						   @RequestParam(required = false, defaultValue = "10", value = "pageSize") int pageSize,
						   @RequestParam(required = false, defaultValue = "", value = "search") String search,
						   @RequestParam(required = false, value = "sort") String sort,
						   @RequestParam(required = false, value = "sortOrder") String sortOrder){
		EntityWrapper<Role> wrapper = new EntityWrapper<>();
		Page<Role>  page = new Page<Role>(pageNumber,pageSize);
		Page<Role> result = roleService.selectPage(page,wrapper);
		//  List<Dept> list = deptService.selectList(null);
		return AjaxResult.ok("查询成功").put("rows",result.getRecords()).put("total",result.getTotal());
	}


	/**
	 * 添加应用数据
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult insert(@RequestBody Role   role){
		if (role.getId()==null){
			roleService.insert(role);
			return AjaxResult.ok("添加成功");
		}else {
			roleService.updateById(role);
			return AjaxResult.ok("更新成功");
		}

	}
}
