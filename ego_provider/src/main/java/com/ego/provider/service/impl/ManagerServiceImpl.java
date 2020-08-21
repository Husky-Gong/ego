package com.ego.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ego.dubbo.api.ManagerService;
import com.ego.mapper.ManagerMapper;
import com.ego.pojo.Manager;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 是Dubbo的服务提供者，必须使用Dubbo的注解Service描述。
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 根据用户名查询用户。
     * @param username 用户名
     * @return 数据不存在返回null。 访问数据库发生异常返回null。
     */
    @Override
    public Manager getManagerByUserName(String username) {
        try {
            // 创建查询条件。
            QueryWrapper<Manager> queryWrapper =
                    new QueryWrapper<Manager>()
                            .eq("username", username);
            Manager manager = managerMapper.selectOne(queryWrapper);
            return manager;
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
}
