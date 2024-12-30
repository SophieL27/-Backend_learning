package org.swust.sysmonitorapp.entity.qparam;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class QSysUser {
    /**
     * 用户名字
     */

    private String username;

    /**
     * 所属部门id
     */

    private Long depid;

    /**
     * 用户id
     */

    private Long useid;

    /**
     * 用户性别
     */

    private String sex;
    /**
     * 角色id
     */
    private Long roleid;
}
