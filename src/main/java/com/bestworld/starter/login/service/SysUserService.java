package com.bestworld.starter.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bestworld.starter.login.bean.SysUser;

public interface SysUserService extends IService<SysUser> {

	SysUser getByUsername(String username);

	String getUserAuthorityInfo(Long userId);
}
