package com.orl.auth.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orl.auth.entity.User;
import com.orl.auth.mapper.UserMapper;
import com.orl.auth.service.UserService;
@Service
@Transactional
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService{

	@Override
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		checkUser(user);
		this.insert(user);
	}

	private void checkUser(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setUserId(UUID.randomUUID().toString());
		String userName = user.getUserName();
		int userCount = this.selectCount(new EntityWrapper<User>().eq("USER_NAME", userName));
		if(userCount!=0) {
			throw new Exception("该名称已经被占用，请换一个名称");
		}
	}
}
