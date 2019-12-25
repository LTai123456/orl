package com.orl.auth.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName("orl_user")
public class User{

	private String userId;
	private String userName;
	private String userPass;
	private String userCode;
	private String userPhone;
	private String userMail;
	private String userDesc;
}
