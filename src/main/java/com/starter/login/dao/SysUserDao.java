package com.starter.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starter.login.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Mapper
public interface SysUserDao extends BaseMapper<User> {

    List<Long> getNavMenuIds(Long userId);

    List<User> listByMenuId(Long menuId);

    User getByUsername(String username);

    String getUserAuthorityInfo(Long userId);
}
