package org.swust.sysmonitorapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.swust.sysmonitorapp.entity.SystemDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author sophie
 * @since 2024-12-24
 */
@Mapper
public interface SystemDeptMapper extends BaseMapper<SystemDept> {

    @Update("update system_dept set status = #{status} where id = #{id}")
    int editStatus(@Param("id") Integer id,
                   @Param("status") Integer status);
    @Update("UPDATE system_dept SET num = num + 1 WHERE id = #{deptId}")
    int incrementNumUsers(@Param("deptId") Long deptId);
}
