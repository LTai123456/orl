package com.orl.auth.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orl.auth.entity.Role;
import com.orl.auth.service.RoleService;
import com.orl.auth.vo.Response;

@Controller
public class AuthSignController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public Response<List<Role>> queryAllRoles(){
		Response<List<Role>> response = new Response<>();
		response.setData(roleService.queryRoles());
		response.setCode(200);
		return response;
	}
	@RequestMapping("/login")
	public String userLogin(){
	       return "demo-sign";
	}
}
