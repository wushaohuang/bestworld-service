package com.starter.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starter.login.bean.SysUser;
import com.starter.login.dao.SysUserDao;
import com.starter.login.service.SysUserService;
import com.starter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public SysUser getByUsername(String username) {
        return getOne(new QueryWrapper<SysUser>().eq("username", username));
    }

    @Override
    public String getUserAuthorityInfo(Long userId) {

        SysUser sysUser = sysUserDao.selectById(userId);

        //  ROLE_admin,ROLE_normal,sys:user:list,....
        String authority = "";
        authority = (String) redisUtil.get("GrantedAuthority:" + sysUser.getUser_name());
        return authority;
    }

}
