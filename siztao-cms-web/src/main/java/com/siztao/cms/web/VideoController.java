package com.siztao.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/send/api",method = RequestMethod.GET)
    @ResponseBody
    public String send(@RequestParam("id")String id){

        return "success";
    }
    @RequestMapping(value = "/send/api",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Map<String,String> map, @RequestParam("id")String id){

        return "success";
    }
    class Danmuku{
        private String _id;
        private String  author;
        private String time;
        private String text;
        private String color;
        private String type;
        private String ip;
        private String referer;
        private Integer _v;
        private String player;
    }
}
