package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SawonDAO;
import vo.SawonVO;

@Controller
public class SawonController {

	public static final String VIEW_PATH = "/WEB-INF/views/sawon/";
	
	SawonDAO sawon_dao;
	
//	public SawonController(SawonDAO sawon_dao) {
//		this.sawon_dao = sawon_dao;
//	}
	
	public void setSawon_dao(SawonDAO sawon_dao) {
		this.sawon_dao = sawon_dao;
	}
	
	@RequestMapping("/sawon_list.do")
	public String list(Model model) {
		
		List<SawonVO> list = sawon_dao.selectList();
		
		model.addAttribute("list", list);
		
		return VIEW_PATH + "sawon_list.jsp";
	}
	
}
