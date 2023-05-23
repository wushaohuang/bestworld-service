package com.bestworld.scp.toolbox.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bestworld.scp.toolbox.service.ToolboxService;
import com.bestworld.starter.login.bean.SysUser;
import com.bestworld.starter.login.dao.SysUserDao;
import org.springframework.stereotype.Service;

@Service
public class ToolboxServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ToolboxService {
}
