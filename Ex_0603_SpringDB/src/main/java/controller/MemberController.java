package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDAO;
import vo.MemberVO;

@Controller
public class MemberController {

	public static final String VIEW_PATH = "WEB-INF/views/member/";
	
	MemberDAO member_dao;
	
	public MemberController(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}

	@RequestMapping("/member_list.do")
	public String list(Model model) {
		
		List<MemberVO> list = member_dao.selectList();
		
		model.addAttribute("list", list);
			
		return VIEW_PATH + "member_list.jsp";
		
	}

}




