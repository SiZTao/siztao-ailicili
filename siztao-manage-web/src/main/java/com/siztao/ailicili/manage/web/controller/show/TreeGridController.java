package com.siztao.ailicili.manage.web.controller.show;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-20 12:05
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-20 12:05
 * @email: 982637685@qq.com
 * @version:
 **/
@Controller
@RequestMapping("showCase/treeGrid")
public class TreeGridController {
    private static final String PAGE_VIEW= "show/";

    @RequestMapping(method = RequestMethod.GET)
    public String addView(){
        return PAGE_VIEW+"/treeGrid";
    }
}
