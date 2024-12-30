package org.swust.sysmonitorapp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.swust.sysmonitorapp.entity.SysUserDto;
import org.swust.sysmonitorapp.entity.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.swust.sysmonitorapp.entity.qparam.QSysUser;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sophie
 * @since 2024-12-27
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    IPage<SysUserDto> pageUser(Page page,@Param("param") QSysUser qSysUser);
    /*@Update("update system_user set password = #{psw} where useid = #{userId}")
    int changePassword(Long userId, String psw);
*/
    @Update("update system_user set password = #{pwd} where useid = #{useid}")
    int resetPwd(Long useid,String pwd);


}
