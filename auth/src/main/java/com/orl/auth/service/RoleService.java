package com.orl.auth.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.orl.auth.entity.Role;


public interface RoleService extends IService<Role>{

	public List<Role> queryRoles();
}
