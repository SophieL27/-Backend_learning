package org.swust.sysmonitorapp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swust.sysmonitorapp.entity.*;
import org.swust.sysmonitorapp.entity.qparam.QSysUser;
import org.swust.sysmonitorapp.service.ISystemDeptService;
import org.swust.sysmonitorapp.service.ISystemUserService;


/**
 *  用户表 前端控制器
 * @author sophie
 * @since 2024-12-27
 */
@RestController
@RequestMapping("/systemUser")
public class SystemUserController {
    @Autowired
    private ISystemUserService userService;

    
    /**
     * 查询用户
     * @param useid 用户id
     * @return 部门详细信息
     */
    @GetMapping("/{useid}")
    public R<SystemUser> gerById(@PathVariable(name="useid") Integer useid){
        SystemUser user=userService.getById(useid);
        return R.ok(user);
    }
    /**
     * 添加用户的同时将部门表的部门人数num加一
     *
     * @param user 用户信息
     * @return success/false
     */
    @PostMapping
    public R<SystemUser> save(@RequestBody SystemUser user) {
        userService.saveUserAndUpdateDeptNum(user);
        return R.ok();
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping
    public R<SystemUser> edit(@RequestBody SystemUser user) {
        userService.updateById(user);
        return R.ok();
    }


    /**
     * 删除用户
     * @param useid
     * @return
     */
    @DeleteMapping("/{useid}")
    public R<SystemUser> delete(@PathVariable(name="useid") Integer useid) {
        userService.removeById(useid);
        return R.ok();
    }
    /**
     * 分页查询用户
     *
     * @param page    参数集
     * @param qSysUser 查询参数列表
     * @return 用户集合
     */
    @GetMapping("/page")
    public R<IPage<SysUserDto>>  Page(Page page, QSysUser qSysUser) {
        return R.ok(userService.pageUser(page, qSysUser));
    }

    /*
     * 修改密码并删除token
     * @param changePsw
     * @return
     */
    /*@PutMapping("/changePsw")
    public R changePsw(@Valid @RequestBody ChangePsw changePsw) {

        boolean result = userService.changePsw(changePsw.getOldPsw(), changePsw.getNewPsw());
        if(result){
            return R.ok("密码修改成功");
        }else{
            return R.failed("原始密码输入错误，修改失败！");
        }

    }*/

    /**
     * 重置密码
     * @param useid
     * @return
     */
    @PutMapping("/resetPwd")
    public R resetPwd(Long useid) {
        Boolean result=userService.resetPwd(useid);
        return result?R.ok(result):R.failed(result);
    }

}
