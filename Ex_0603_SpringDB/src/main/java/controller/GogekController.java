package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GogekDAO;
import vo.GogekVO;

@Controller
public class GogekController {

	public static final String VIEW_PATH = "/WEB-INF/views/gogek/"; // 절대경로 선언
																	// gogek폴더 안
	GogekDAO gogek_dao;  // DAO 객체 생성
	
	public GogekController(GogekDAO gogek_dao) { // 생성자를 사용하려면 GogekDAO 형식을 가진 파라미터를 써야됌.
		this.gogek_dao = gogek_dao;     		 // 그파라미터를 gogek_dao에 넣어줌.
	}
	
	@RequestMapping("/gogek_list.do")
	public String list(Model model) {
		
		List<GogekVO> list = gogek_dao.selectList();
		
		model.addAttribute("list", list);
		
		return VIEW_PATH +"gogek_list.jsp"; 
	}
	
}
