package com.korea.mall;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserDAO user_dao;
	
	@Autowired
	private KakaoService kakaoService;

	public void setUser_dao(UserDAO user_dao) {
		this.user_dao = user_dao;
	}
	
	@RequestMapping(value={"login_form.do"})
	public String home() {
		return "/WEB-INF/views/user/login_form.jsp";
	}
	
	@RequestMapping("register_form.do")
	public String register_form() {
		return "/WEB-INF/views/user/register_form.jsp";
	}
	
	
	// 이메일 중복체크
	@RequestMapping("emailCheck.do")
	@ResponseBody
	public String emailCheck(String email) {
		
		int resInt = user_dao.emailCheck(email);
		
		String resultStr;
		String res = "yes";
		
		if(resInt == 1) {
			res = "no";
		}
		
		resultStr = String.format("[{'res':'%s'}]", res);
		
		return resultStr;
	}
	
	
	// 회원가입
	@RequestMapping("register.do")
	@ResponseBody
	public String register(String email, String pwd, String name, String phone) {
		
		UserVO vo = new UserVO();
		
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setPhone(phone);
		
		int resInt = user_dao.register(vo);
		
		String resultStr;
		String res = "yes";
		
		if(resInt == 0) {
			res = "no";
		}
		
		System.out.println("== con 70==");
		System.out.println("res = " +res);
		
		resultStr = String.format("[{'res':'%s'}]", res);
		
		return resultStr;
	}
	
	
	@RequestMapping("login.do")
	public String login() {
		
		return "/WEB-INF/views/user/login.jsp";
	}
	
	
	// 로그인
	@RequestMapping("login_1.do")
	@ResponseBody
	public String login_1(String email, String pwd, HttpServletRequest request, Model model) {
		
		
		UserVO vo = user_dao.login(email, pwd);
		
		model.addAttribute("email", vo.getEmail());
		model.addAttribute("name", vo.getName());
		
		HttpSession session = request.getSession();
		
		session.setAttribute("vo", vo);
		
		return vo.getEmail();
	}
	
	
	
	@RequestMapping("/login")
    public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
        System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);
        return "testPage";
    }
	
	
	
	
	
	
	
	

	

}







