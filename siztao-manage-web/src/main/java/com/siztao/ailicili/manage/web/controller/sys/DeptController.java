package com.siztao.ailicili.manage.web.controller.sys;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siztao.ailicili.service.manage.api.sys.DeptService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.framework.cache.RedisCache;
import com.siztao.framework.model.AjaxResult;
import com.siztao.framework.model.ZtreeVo;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.swing.text.html.parser.Entity;
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
public class DeptController extends AbstractController{
    private static Logger LOG = LoggerFactory.getLogger(DeptController.class);

    private static final String PAGE_VIEW= "manage/sys/dept";

	@Autowired
    private DeptService deptService;


    @RequestMapping(method = RequestMethod.GET)
    public String page(){
        return PAGE_VIEW+"/list";
    }

    @RequestMapping(value = "/addView",method = RequestMethod.GET)
    public String addView(Model   model){
        LOG.info("添加组织机构");
        return PAGE_VIEW+"/add";
    }

    @ResponseBody
    @RequestMapping(value = "/editView",method = RequestMethod.GET)
    public AjaxResult editView(@RequestParam("deptId") Integer  deptId){
        LOG.info("权限管理系统:deptId{}","editView"+deptId);
        Dept dept = deptService.selectById(deptId);
        return AjaxResult.ok("机构数据").put("dept",dept);
    }

    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insert(@RequestBody Dept   dept){
        if (dept.getId()==null){
            deptService.insert(dept);
            return AjaxResult.ok("添加成功");
        }else {
            deptService.updateById(dept);
            return AjaxResult.ok("更新成功");
        }

    }
    /**
     * 删除应用数据
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(@RequestParam("deptId") Integer deptId){
        boolean flag = deptService.deleteById(deptId);
        return AjaxResult.ok("删除成功");
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult list(@RequestParam(required = false, defaultValue = "0", value = "pageNumber") int pageNumber,
                           @RequestParam(required = false, defaultValue = "10", value = "pageSize") int pageSize,
                           @RequestParam(required = false, defaultValue = "", value = "search") String search,
                           @RequestParam(required = false, value = "sort") String sort,
                           @RequestParam(required = false, value = "sortOrder") String sortOrder){
        EntityWrapper<Dept> wrapper = new EntityWrapper<>();
        Page<Dept>  page = new Page<Dept>(pageNumber,pageSize);
        Page<Dept>  result = deptService.selectPage(page,wrapper);
      //  List<Dept> list = deptService.selectList(null);
        return AjaxResult.ok("查询成功").put("rows",result.getRecords()).put("total",result.getTotal());
    }

    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    @ResponseBody
    public  List<ZtreeVo> getDeptTree(@RequestParam(required = false, defaultValue = "false", value = "showTopParent")Boolean showTopParent,
                              @RequestParam(required = false, defaultValue = "true", value = "open") Boolean open,
                              @RequestParam(required = false, defaultValue = "true", value = "enable")  Boolean enable){
        List<Dept>  vos = deptService.selectList(null);
        List<ZtreeVo> deptTree = deptService.selectAllDeptWithZtree(showTopParent,vos);
        return deptTree;
    }

    public static List<ZtreeVo> setPZtreeCheck(List<ZtreeVo> list,Boolean open){
        for(ZtreeVo ztreeVo:list){
            ztreeVo.setChecked(false);
            ztreeVo.setOpen(open);
        }
        return list;
    }
}
