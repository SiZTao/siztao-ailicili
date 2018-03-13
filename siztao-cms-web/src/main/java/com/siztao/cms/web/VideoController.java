package com.siztao.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-14 00:27
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-14 00:27
 * @email: 982637685@qq.com
 * @version:
 **/
@Controller
public class VideoController {

    @RequestMapping("/vms/tovideo")
    public String toList(){
        return "videolist";
    }

    @RequestMapping("/v/{avId}")
    public String play(@PathVariable("avId")String avId){

        return "vplay";
    }
    @RequestMapping("/send")
    @ResponseBody
    public String send(Map<String,Object> map){

        return "success";
    }
}
