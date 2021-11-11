package com.korea.android;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AndDAO;
import vo.AndVO;

@Controller
public class AndController {
	
	AndDAO and_dao;
	
	public void setAnd_dao(AndDAO and_dao) {
		this.and_dao = and_dao;
	}
	
	//회원가입을 위한 매핑
	@RequestMapping(value= {"/", "list.do"})
	@ResponseBody
	public String list(AndVO vo, String type) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		System.out.println(type);
		
		if( type == null) {
			
			return "{res:[{'reslt':'fail'}]}";
		
		}else if(type.equals("type_regi")) {
			
			int res = and_dao.insert(vo);
			
			if(res == 1) {
				System.out.println("가입성공");
				return "{res:[{'reslt':'success'}]}";
			}
		}
		
		
		
		return "{res:[{'reslt':'fail'}]}";
	}
	
	//로그인을 위한 메서드
	@RequestMapping("/login.do")
	@ResponseBody
	public String login( AndVO vo, String type) {
		
		if(type.equals("type_login")) {
			
			AndVO baseVO = and_dao.selectOne(vo);
			
			if(baseVO == null) {
				//아이디나 비밀번호가 일치하지 않는경우
				return "{res:[{'reslt':'fail'}]}";
			}
		}
		
		//서버에서 vo에 닉네임을 담아왔다고 가정
		String nickname = "hong";
		
		return String.format("{res:[{'reslt':'success'}, {'nick':'%s'}]}", nickname);
	}
	
}











