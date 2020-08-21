package com.ego.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 后台安全认证配置类型
 */
@Configuration
public class EgoManageSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 认证表单相关配置
        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .successForwardUrl("/success")
                .failureForwardUrl("/failure");

        // 权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        // csrf
        http.csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
