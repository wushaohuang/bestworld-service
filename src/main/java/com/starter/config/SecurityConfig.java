package com.starter.config;

import com.starter.login.dao.SysUserDao;
import com.starter.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	LoginFailureHandler loginFailureHandler;

	@Autowired
	LoginSuccessHandler loginSuccessHandler;

	@Autowired
	CaptchaFilter captchaFilter;

	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	JwtAccessDeniedHandler jwtAccessDeniedHandler;


	@Autowired
	JwtLogoutSuccessHandler jwtLogoutSuccessHandler;

	@Bean
	JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
		return new JwtAuthenticationFilter(authenticationManager());
	}

	@Bean
	//告知mybatis数据库加密方式
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private static final String[] URL_WHITELIST = {
			"/login",
			"/logout",
			"/captcha",
			"/favicon.ico",
			"/calculation_cash_flow",
			"/calculation_cash_flow/report1"
	};

	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable()

				// 登录配置
				.formLogin()
				.successHandler(loginSuccessHandler)
				.failureHandler(loginFailureHandler)

//				.and()
//				.logout()
//				.logoutSuccessHandler(jwtLogoutSuccessHandler)

				// 禁用session
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				// 配置拦截规则
				.and()
				.authorizeRequests()
				.antMatchers("/user/login").anonymous()
				.antMatchers(URL_WHITELIST).permitAll()
				.anyRequest().authenticated()

				// 异常处理器
				// 用于处理登录失败，权限不足时的异常抛出
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.accessDeniedHandler(jwtAccessDeniedHandler)

				// 配置自定义的过滤器
				.and()
				.addFilter(jwtAuthenticationFilter())
				.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
		;
	}
}
