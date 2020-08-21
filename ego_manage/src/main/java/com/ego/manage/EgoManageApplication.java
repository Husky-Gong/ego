package com.ego.manage;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 默认的SpringBoot开发环境中，不推荐使用JSP作为视图。
 * 那么启动SpringBoot应用的时候，默认是不提供JSP视图处理能力的。
 * 修改IDEA启动参数即可。
 *   run -> edit configurations -> 找到对应SpringBoot启动应用
 *       -> even -> working dir -> $MODULE_WORKING_DIR$
 */
@SpringBootApplication
@EnableDubbo
public class EgoManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(EgoManageApplication.class, args);
    }
}