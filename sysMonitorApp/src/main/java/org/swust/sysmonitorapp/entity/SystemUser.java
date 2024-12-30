package org.swust.sysmonitorapp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author sophie
 * @since 2024-12-27
 */
@Getter
@Setter
@TableName("system_user")
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名字
     */
    @TableField("username")
    private String username;

    /**
     * 所属部门id
     */
    @TableField("depid")
    private Long depid;

    /**
     * 用户id
     */
    @TableId("useid")
    private Long useid;

    /**
     * 用户性别
     */
    @TableField("sex")
    private String sex;
    /**
     * 用户密码
     */
    @TableField("password")
    private String password;
    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

}
