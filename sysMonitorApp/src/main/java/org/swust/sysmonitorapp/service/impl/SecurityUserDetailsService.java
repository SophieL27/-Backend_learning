package org.swust.sysmonitorapp.service.impl;

import org.swust.sysmonitorapp.entity.SystemUser;
import org.swust.sysmonitorapp.service.ISystemUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.swust.sysmonitorapp.entity.SecurityUserDetails;

import java.util.ArrayList;

@Component
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private  ISystemUserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            SystemUser user = userService.getOne(new QueryWrapper<SystemUser>().eq("username", username));
            SecurityUserDetails userDetails = new SecurityUserDetails(username, user.getNickname(),
                    user.getPassword(), new ArrayList<>(),
                    true, true, true, true);
            userDetails.setUser(user);
            log.info("登录用户信息：{}", user);
            return userDetails;
        } catch (Exception e) {
            String msg = "Username: " + username + " not found";
            log.error(msg, e);
            throw new UsernameNotFoundException(msg);
        }
    }
}