package com.korea.and;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import vo.UserVO;

@Controller
public class UserController {
	
	UserDAO user_dao;
	
	public void setUser_dao(UserDAO user_dao) {
		this.user_dao = user_dao;
	}
	
	@RequestMapping("/regi.do")
	@ResponseBody
	public String register( UserVO vo ) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		
		user_dao.register(vo);
		
		return "";
	}

}
