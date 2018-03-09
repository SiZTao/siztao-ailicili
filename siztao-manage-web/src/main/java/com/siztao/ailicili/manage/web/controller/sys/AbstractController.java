package com.siztao.ailicili.manage.web.controller.sys;

import com.siztao.ailicili.service.manage.entity.sys.User;
import com.siztao.framework.cache.RedisCache;
import com.siztao.framework.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-05 12:23
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-05 12:23
 * @email: 982637685@qq.com
 * @version:
 **/
@Controller
public abstract class AbstractController {
    private static Logger LOG = LoggerFactory.getLogger(AbstractController.class);

    @Autowired
    RedisCache redisCache;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值

    }
    protected User  getUser(){
        return (User) ShiroUtils.getUser();
    }
    protected Integer getUserId(){
        return getUser().getId();
    }
}
