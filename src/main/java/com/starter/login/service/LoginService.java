package com.starter.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starter.common.lang.Result;
import com.starter.login.bean.User;

public interface LoginService extends IService<User> {

	Result login(User user);
}
