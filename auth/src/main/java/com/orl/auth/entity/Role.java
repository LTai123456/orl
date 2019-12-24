package com.orl.auth.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName("orl_role")
public class Role {
	@TableId
	private Integer roleId;
	private String roleCode;
	private String roleName;
	private String  roleDesc;
}
