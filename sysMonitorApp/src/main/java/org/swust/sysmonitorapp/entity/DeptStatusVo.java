package org.swust.sysmonitorapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DeptStatusVo {


    private Integer id;
    private Integer status;

}
