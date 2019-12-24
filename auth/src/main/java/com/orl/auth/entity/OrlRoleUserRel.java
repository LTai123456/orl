package com.orl.auth.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 尼古拉斯-肖
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("orl_role_user_rel")
public class OrlRoleUserRel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private String userId;
    @TableField("role_id")
    private Integer roleId;


}
