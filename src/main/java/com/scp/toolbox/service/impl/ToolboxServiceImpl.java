package com.scp.toolbox.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scp.toolbox.service.ToolboxService;
import com.starter.login.bean.SysUser;
import com.starter.login.dao.SysUserDao;
import org.springframework.stereotype.Service;

public class ToolboxServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ToolboxService {
}
