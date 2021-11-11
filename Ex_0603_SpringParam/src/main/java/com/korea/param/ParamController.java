package com.korea.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.PersonVO;

@Controller
public class ParamController {

	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	@RequestMapping(value={"/", "/insert_form.do"})
	public String insert_form() {
		
		return VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("/insert1.do")  // return으로 포워딩이 스트링 타입이니 함수타입을 String으로 해준다?
	public String insert1( Model model, String name, int age, String tel ) {
		//insert1.do로 전달된 name, age, tel이
		//insert1()메서드의 같은 이름의 변수로 자동 대임. 정수형태의 값은 형변환되서 처리됌.
		
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setTel(tel);
		
		//파라미터로 받은 값을 model에 바인딩
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "insert_result.jsp";
	}
	
	//객체로 파라미터 받기
	@RequestMapping("/insert2.do")
	public String insert2(Model model, PersonVO vo) {
		// 파라미터로 넘어온 값을 vo에 속성(name, age, tel)이 일치하는 변수에 자동으로 대입
		
		// insert2(Model model, PersonVO vo, String name)
		// vo에 이미 존재하는 변수가 파라미터로 또 넘어오면 오류 발생
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "insert_result.jsp";
	}
	
	
}
