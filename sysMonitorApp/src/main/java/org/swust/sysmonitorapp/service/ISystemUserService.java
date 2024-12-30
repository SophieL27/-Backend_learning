package org.swust.sysmonitorapp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.swust.sysmonitorapp.entity.SysUserDto;
import org.swust.sysmonitorapp.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.swust.sysmonitorapp.entity.qparam.QSysUser;

/**
 * <p>
 *  用户表 服务类
 * </p>
 *
 * @author sophie
 * @since 2024-12-27
 */
public interface ISystemUserService extends IService<SystemUser> {

    void saveUserAndUpdateDeptNum(SystemUser user);

    IPage<SysUserDto>  pageUser(Page page, QSysUser qSysUser);
    /*boolean changePsw(String oldPwd,String newPwd);*/

    boolean resetPwd(Long useid);
}
