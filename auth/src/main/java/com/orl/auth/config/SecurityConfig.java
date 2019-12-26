package com.orl.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.orl.auth.providerhandler.MyAuthenticationFailHander;
import com.orl.auth.providerhandler.MyAuthenticationProvider;
import com.orl.auth.providerhandler.MyAuthenticationSuccessHandler;

//import com.orl.auth.service.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyAuthenticationProvider provider;
	
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	@Autowired
	private MyAuthenticationFailHander myAuthenticationFailHander;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .formLogin().loginPage("/login").loginProcessingUrl("/login/form")
         .successHandler(myAuthenticationSuccessHandler)
         .successForwardUrl("/whoim")
         .failureHandler(myAuthenticationFailHander).permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
         .and()
         .authorizeRequests().anyRequest().authenticated()                  
         .and()
         .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**","/images/**","/img/**","/layui/**","/regist/**");
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
                
    	auth.authenticationProvider(provider);
//                auth
//                .inMemoryAuthentication()
//                      .withUser("admin").password("123456").roles("USER")
//                      .and()
//                      .withUser("test").password("test123").roles("ADMIN");
    }


}