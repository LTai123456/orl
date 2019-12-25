package com.orl.auth.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orl.auth.entity.Role;
import com.orl.auth.service.RoleService;
import com.orl.auth.vo.Response;

@Controller
public class AuthSignController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	@ResponseBody
	public Response<List<Role>> queryAllRoles(){
		Response<List<Role>> response = new Response<>();
		response.setData(roleService.queryRoles());
		response.setCode(200);
		return response;
	}
	@RequestMapping("/login")
	public String userLogin(){
	       return "index.html";
	}
	
	@RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return "home.html";
    }
	
//	@RequestMapping("/login/form")
//	public String userLoginForm(@RequestBody Map mp){
//		   //處理登錄表儅
//	    return "loginXX.html";
//	}
	
	@RequestMapping("/login/error")
	public String loginError(){
	    return "loginError.html";
	}
	
	 @RequestMapping("/whoim")
	 @ResponseBody
     public Object whoIm(){
           return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     }
}
