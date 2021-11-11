package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

// @Component
//  ㄴ @Controller
//  ㄴ @Service
//  ㄴ @Repository

// @Component 어노테이션의 자식 타입에 대해서는 추후 Auto Detecting 기능을 통해
// 자동완선 기능이 제공된다.

@Controller
public class TestController {

	@Autowired
	DeptDAO dept_dao;  // @Repository("dept_Dao") --> DAO의 객체명과 별칭을 일치 시켜야 한다.
	
	public TestController() {
		System.out.println("TestController의 생성자");
	}
	
	@RequestMapping(value= {"/","list.do"})
	public String deptList(Model model) {
		
		List<DeptVO> dept_list = dept_dao.selectList();
		
		model.addAttribute("list", dept_list);
		
		return "/WEB-INF/views/dept/dept_list.jsp";
		
	}

}










