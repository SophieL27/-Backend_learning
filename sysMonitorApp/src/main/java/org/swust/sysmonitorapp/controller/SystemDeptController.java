package org.swust.sysmonitorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swust.sysmonitorapp.entity.DeptStatusVo;
import org.swust.sysmonitorapp.entity.R;
import org.swust.sysmonitorapp.entity.SystemDept;
import org.swust.sysmonitorapp.entity.UserStatusVo;
import org.swust.sysmonitorapp.service.ISystemDeptService;

/**
 * 部门表 前端控制器
 *
 * @author sophie
 * @since 2024-12-24
 */
@RestController
@RequestMapping("/systemDept")

public class SystemDeptController {
    @Autowired
    private ISystemDeptService deptService;
    /**
    * 查询部门
    * @param id 部门id
    * @return 部门详细信息
     */
    @GetMapping("/{id}")
    public R<SystemDept> gerById(@PathVariable(name="id") Integer id){
        SystemDept dept=deptService.getById(id);
        return R.ok(dept);
    }
    /**
     * 添加部门
     *
     * @param dept 部门信息
     * @return success/false
     */
    @PostMapping
    public R<SystemDept> save(@RequestBody SystemDept dept) {
        deptService.save(dept);
        return R.ok();
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PutMapping
    public R<SystemDept> edit(@RequestBody SystemDept dept) {
        deptService.updateById(dept);
        return R.ok();
    }

    /**
    * 修改部门状态
    * @param deptStatusVo
    * @return
     */
    @PutMapping("/status")
    public R editStatus(@RequestBody DeptStatusVo deptStatusVo) {
        Boolean result=deptService.editStatus(deptStatusVo.getId(),deptStatusVo.getStatus());
        return result?R.ok(result):R.failed();
    }
    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R<SystemDept> delete(@PathVariable(name="id") Integer id) {
        deptService.removeById(id);
        return R.ok();
    }

}
