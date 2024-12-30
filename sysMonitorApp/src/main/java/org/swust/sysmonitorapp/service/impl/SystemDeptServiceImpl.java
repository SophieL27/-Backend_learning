package org.swust.sysmonitorapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.swust.sysmonitorapp.entity.SystemDept;
import org.swust.sysmonitorapp.mapper.SystemDeptMapper;
import org.swust.sysmonitorapp.service.ISystemDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author sophie
 * @since 2024-12-24
 */
@Service
public class SystemDeptServiceImpl extends ServiceImpl<SystemDeptMapper, SystemDept> implements ISystemDeptService {


    /**
     * 修改指定ID的部门状态
     *
     * @param id     部门ID
     * @param status 状态码
     * @return 修改成功返回true，否则返回false
     */
    @Override/*   @Autowired
    private SystemDeptMapper systemDeptMapper;*/
    public Boolean editStatus(Integer id, Integer status) {
        int result = baseMapper.editStatus(id, status);
        return result > 0;
    }


}
