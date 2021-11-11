package com.korea.vs2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {

	public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	DeptDAO dept_dao;
	
	public void setDept_dao(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping(value = {"/", "list.do"})
	public String selectList(Model model) {
		
		List<DeptDAO> list = dept_dao.selectList();
		
		model.addAttribute("list", list);
		
		return VIEW_PATH + "dept_list.jsp";
	}
	
}
