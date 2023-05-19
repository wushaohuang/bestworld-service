package com.bestworld.starter.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bestworld.starter.login.bean.SysUser;
import com.bestworld.starter.login.dao.SysUserDao;
import com.bestworld.starter.login.service.SysUserService;
import com.bestworld.starter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
	@Autowired
	SysUserDao sysUserDao;

	@Autowired
	RedisUtil redisUtil;

	@Override
	public SysUser getByUsername(String username) {
		return getOne(new QueryWrapper<SysUser>().eq("username", username));
	}

	@Override
	public String getUserAuthorityInfo(Long userId) {

		SysUser sysUser = sysUserDao.selectById(userId);

		//  ROLE_admin,ROLE_normal,sys:user:list,....
		String authority = "";
		authority = (String) redisUtil.get("GrantedAuthority:" + sysUser.getUsername());
		return authority;
	}

}
