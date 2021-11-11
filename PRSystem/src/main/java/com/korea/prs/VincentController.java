package com.korea.prs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VincentDAO;
import vo.VincentVO;



@Controller
public class VincentController {
	
	VincentDAO vincentDao;
	
	public void setVincentDao(VincentDAO vincentDao) {
		
		this.vincentDao = vincentDao;
	}
	
	
	@RequestMapping("/register.do")
	@ResponseBody //결과 Ajax로 return
	public String register( VincentVO vo ) {
		
		System.out.println(vo.getEmail());
		System.out.println(vo.getPwd());
		System.out.println(vo.getName());
		System.out.println(vo.getPnum());
		
		return vincentDao.register(vo);
		
	}
	
	
	@RequestMapping(value = {"/login.do"})
	@ResponseBody
	public String login(VincentVO vo) {
		
		String res = vincentDao.login(vo);
		
		if(res.equals("fail")) {
			
			return "{res:[{'result':'fail'}]}";
		}
		
		return "{res:[{'result':'success'}]}";
	
	}
	

}
