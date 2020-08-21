package com.ego.manage.service.impl;

import com.ego.dubbo.api.ManagerService;
import com.ego.pojo.Manager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 实现Security中的UserDetailsService接口，提供认证功能
 * 当前类型是本地服务实现，Spring容器管理bean对象，使用Spring的Service注解描述
 */
@Service
public class ManagerLoginServiceImpl implements UserDetailsService {
    /**
     * Dubbo Consumer变量定义
     * 连接zk，创建远程服务的本地代理对象。
     */
    @Reference
    private ManagerService managerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用远程服务，查询用户
        Manager manager = managerService.getManagerByUserName(username);
        // 判断用户是否存在
        if(null == manager){
            throw new UsernameNotFoundException("用户不存在");
        }

        return new User(
                username,
                manager.getPassword(),
                AuthorityUtils
                        .createAuthorityList("ROLE_EGO_Manager")
        );
    }
}
