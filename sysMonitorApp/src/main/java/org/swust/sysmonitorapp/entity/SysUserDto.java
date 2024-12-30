package org.swust.sysmonitorapp.entity;

import org.swust.sysmonitorapp.entity.SystemUser;
import lombok.Data;

@Data
public class SysUserDto extends SystemUser {
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 角色名称
     */
    private String roleName;
}
