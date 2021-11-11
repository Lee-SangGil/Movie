package com.korea.vs2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import vo.VisitVO;

@Controller
public class VisitController {

	public static final String WEB_PATH = "/WEB-INF/views/visit/";
	
	VisitDAO visit_dao;
	
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	
	@RequestMapping(value = {"/" , "list.do"})
	public String selectList(Model model){
		
		List<VisitVO> list = visit_dao.selectList();
		
		model.addAttribute("list", list);
		
		return WEB_PATH + "visit_list.jsp";
	}
	
	
}
