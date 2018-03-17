package com.siztao.ailicili.service.manage.api.sys;

import com.baomidou.mybatisplus.service.IService;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.framework.model.ZtreeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface DeptService extends IService<Dept> {

    //机构Tree
    List<ZtreeVo>   selectAllDeptWithZtree(boolean isShowTopParent,List<Dept> vos);
}
