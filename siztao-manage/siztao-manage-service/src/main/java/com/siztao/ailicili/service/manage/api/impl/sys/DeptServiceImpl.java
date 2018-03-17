package com.siztao.ailicili.service.manage.api.impl.sys;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siztao.ailicili.service.manage.api.sys.DeptService;
import com.siztao.ailicili.service.manage.dao.sys.DeptMapper;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.framework.model.ZtreeVo;
import com.siztao.framework.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    private DeptMapper  deptMapper;


    @Override
    public List<ZtreeVo> selectAllDeptWithZtree(boolean isShowTopParent, List<Dept> vos) {
        List<ZtreeVo>   results = new ArrayList<ZtreeVo>();
        if (isShowTopParent){
            ZtreeVo result = new ZtreeVo();
            result.setId("-1");
            result.setpId("0");
            result.setName("全部");
            results.add(result);
        }
        if(CollectionUtil.isNotEmpty(vos)){
            for(Dept dept:vos){
                ZtreeVo foo = new ZtreeVo();
                foo.setId(String.valueOf(dept.getId()));
                foo.setpId(String.valueOf(dept.getParentid()));
                foo.setName(dept.getName());
                results.add(foo);
            }
        }
        return results;
    }
}
