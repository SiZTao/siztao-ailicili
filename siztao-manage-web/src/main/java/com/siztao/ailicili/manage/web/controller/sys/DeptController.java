package com.siztao.ailicili.manage.web.controller.sys;


import com.siztao.ailicili.service.manage.api.sys.DeptService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.framework.cache.RedisCache;
import com.siztao.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
@RequestMapping("/manage/dept")
public class DeptController {

    private static final String PAGE_VIEW= "manage/sys/dept/";

	@Autowired
    private DeptService deptService;

    @Autowired
    RedisCache redisCache;

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
        List<Dept> list = deptService.selectList(null);
        redisCache.putListCache("deptList",list);
        return AjaxResult.ok("查询成功").put("rows",list).put("total",list.size());
    }

}
