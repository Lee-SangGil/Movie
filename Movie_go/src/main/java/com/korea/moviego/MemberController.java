package com.korea.moviego;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDAO;

@Controller
public class MemberController {

	public static final String VIEW_PATH = "/WEB-INF/views/member/";
	
	MemberDAO member_dao;
	
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping(value= {"/","login.do"})
	public String login_form() {
		
		return VIEW_PATH + "login_form.jsp";
	}
	
	@RequestMapping("/register_form.do")
	public String register_form() {
		
		return VIEW_PATH + "register_form.jsp";
	}
	
	
}
