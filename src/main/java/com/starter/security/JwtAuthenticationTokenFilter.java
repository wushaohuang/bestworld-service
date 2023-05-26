package com.starter.security;

import com.starter.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		//获取token
		String token = request.getHeader("token");
		if (!StringUtils.hasText(token)) {
			//放行
			filterChain.doFilter(request,response);
			return;
		}
		//解析token
		String userId;
		try {
			Claims claims = JwtUtils.parseJWT(token);
			userId = claims.getSubject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("token非法");
		}
		//从redis中获取用户信息
//		String redisKey = "login:" + userId;
//		SysUser loginUser = (SysUser) RedisUtil.lGetIndex(redisKey);
//		if (Objects.isNull(loginUser)) {
//			throw new RuntimeException("用户未登录");
//		}
		//存入SecurityContextHolder
		//TODO 获取权限信息封装到Authentication中
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(null, null, null);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		//放行
		filterChain.doFilter(request,response);
	}

}
