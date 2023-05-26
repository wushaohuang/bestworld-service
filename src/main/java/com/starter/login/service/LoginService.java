package com.starter.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starter.common.lang.ResponseResult;
import com.starter.login.bean.User;

public interface LoginService extends IService<User> {

	ResponseResult login(User user);
}
