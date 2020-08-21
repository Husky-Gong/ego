package com.ego.dubbo.api;

import com.ego.pojo.Manager;

// 用户服务接口。 用户是电商平台中的管理人员，是后台的用户。
// 对应数据库中的表格是tb_manager
public interface ManagerService {
    /**
     * 根据用户名查询用户。 访问表格是tb_manager
     * @param username 用户名
     * @return 用户对象。 如果用户名不存在，返回null。
     */
    Manager getManagerByUserName(String username);
}

