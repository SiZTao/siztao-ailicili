package com.siztao.service.sys;

import com.alibaba.fastjson.JSON;
import com.siztao.ailicili.service.manage.api.sys.PermissionService;
import com.siztao.test.base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-07 08:25
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-07 08:25
 * @email: 982637685@qq.com
 * @version:
 **/
public class PermissionServiceTest  extends BaseTest {
    private static Logger LOG = LoggerFactory.getLogger(PermissionServiceTest.class);

    @Autowired
    private PermissionService   permissionService;
    @Test
    public void testQueryMenu(){
        LOG.info("AppList:{}", JSON.toJSON( permissionService.getUserMenuList(0,null)));
    }
}
