package com.starter.login.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String user_name;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    private String status;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
    /**
     * 手机号
     */
    private String phonenumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    private String sex;
    /**
     * 上次登录时间
     */
    @Nullable
    private LocalDateTime lastLogin;
    /**
     * 用户类型（0 管理员，1普通用户）
     */
    private String userType;
    /**
     * 创建人的用户id
     */
    private Long create_by;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 更新人
     */
    private Long update_by;
    /**
     * 更新时间
     */
    private Date update_time;
    /**
     * 删除标志（0 代表未删除，1 代表已删除）
     */
    private Integer del_flag;
}
