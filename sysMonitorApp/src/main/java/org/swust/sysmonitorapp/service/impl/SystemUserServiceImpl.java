package org.swust.sysmonitorapp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.swust.sysmonitorapp.entity.SysUserDto;
import org.swust.sysmonitorapp.entity.SystemUser;
import org.swust.sysmonitorapp.entity.qparam.QSysUser;
import org.swust.sysmonitorapp.mapper.SystemDeptMapper;
import org.swust.sysmonitorapp.mapper.SystemUserMapper;
import org.swust.sysmonitorapp.service.ISystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.swust.sysmonitorapp.utils.SecurityUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sophie
 * @since 2024-12-27
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemDeptMapper systemDeptMapper;

    @Transactional
    @Override
    public void saveUserAndUpdateDeptNum(SystemUser user) {
        // 保存用户信息
        systemUserMapper.insert(user);

        // 获取用户的部门ID
        Long deptId = user.getDepid();

        // 如果部门ID不为空，则更新部门人数
        if (deptId != null) {
            systemDeptMapper.incrementNumUsers(deptId);
        }
    }

    @Override
    public IPage<SysUserDto> pageUser(Page page, QSysUser qSysUser) {
        return baseMapper.pageUser(page, qSysUser);
    }


    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();
  /*  @Override public boolean changePsw(String oldPsw, String newPsw) {
        SystemUser user = SecurityUtils.getUser();
        ENCODER.encode(oldPsw);
        if (ENCODER.matches(oldPsw, user.getPassword())) {
            String psw = ENCODER.encode(newPsw);
            return baseMapper.changePassword(user.getUseid(), psw) > 0 ? true : false;
        }
        return false;
    }*/

    @Override
    public boolean resetPwd(Long useid) {
        String pwd=ENCODER.encode("123456");
        return baseMapper.resetPwd(useid,pwd) > 0;
    }
}
