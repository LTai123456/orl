package com.orl.auth.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orl.auth.entity.Role;
import com.orl.auth.entity.User;
import com.orl.auth.service.RoleService;
import com.orl.auth.service.UserService;
import com.orl.auth.vo.Response;

@Controller
public class AuthSignController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/roles")
	@ResponseBody
	public Response<List<Role>> queryAllRoles() {
		Response<List<Role>> response = new Response<>();
		response.setData(roleService.queryRoles());
		response.setCode(200);
		return response;
	}

	@RequestMapping("/login")
	public String userLogin() {
		return "index.html";
	}

	@RequestMapping("/")
	public String showHome() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return "home.html";
	}

	@RequestMapping("/login/error")
	public String loginError() {
		return "loginError.html";
	}

	@RequestMapping("/whoim")
	@ResponseBody
	public Object whoIm() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	/**
	 * regist注冊接口
	 * @throws IOException 
	 * @throws Exception 
	 */
	@PostMapping("/regist/user")
	@ResponseBody
	public void regist(User user,HttpServletResponse re) throws IOException{
		Response<String> response = new Response<>();
		try {
			userService.regist(user);
			response.setCode(200);
			response.setData("");
			response.setMsg("注册成功");
		} catch (Exception e) {
			// TODO: handle exception
			response.setCode(500);
			response.setMsg(e.getMessage());
		}
		re.setStatus(200);
		//re.sendRedirect("/index.html");
	}
}
