package com.ego.provider.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.ego.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 电商EGO服务提供者Provider中的MyBatisPLUS配置类型
 */
@Configuration
public class EgoMyBatisPlusConfiguration {
    /**
     * 提供分页拦截器PaginationInterceptor对象。
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
