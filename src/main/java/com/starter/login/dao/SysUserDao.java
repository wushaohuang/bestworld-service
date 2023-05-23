package com.starter.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starter.login.bean.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Repository
public interface SysUserDao extends BaseMapper<SysUser> {

    List<Long> getNavMenuIds(Long userId);

    List<SysUser> listByMenuId(Long menuId);

}
