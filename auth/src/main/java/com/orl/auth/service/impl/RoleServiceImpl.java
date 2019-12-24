package com.orl.auth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orl.auth.entity.Role;
import com.orl.auth.mapper.RoleMapper;
import com.orl.auth.service.RoleService;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

	

	@Override
	public List<Role> queryRoles() {
		// TODO Auto-generated method stub
		return this.selectList(null);
	}
}
