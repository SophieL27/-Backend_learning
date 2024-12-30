package org.swust.sysmonitorapp.service;

import org.swust.sysmonitorapp.entity.SystemDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author sophie
 * @since 2024-12-24
 */
public interface ISystemDeptService extends IService<SystemDept> {
     Boolean editStatus(Integer id,Integer status);
}
