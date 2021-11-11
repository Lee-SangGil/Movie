package com.korea.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	// 해당 컨트롤러가 포워딩을 하기위한 경로를 임의로 지정
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	public TestController() {
		System.out.println("==test controller의 생성자 입니다.");
	}
	
	@RequestMapping("/test.do")
	public String test( Model model, HttpServletRequest request) {
		
		String[] fruit = {"사과", "배", "오렌지", "키위", "바나나"};
		
		// model객체는 request영역에서 바인딩 기능만을 위임받은 객체이므로
		// ip를 구하려면 실제 request영역이 필요하다
		// request영역을 사용하기 위해  HttpServletRequest을 써줘야 한다.
		String ip = request.getRemoteAddr();
		
		model.addAttribute("fruit", fruit);
		model.addAttribute("ip", ip);
		
		return VIEW_PATH + "test.jsp"; // web-inf/wiews/test/test.jsp로 포워딩 하겟다는 뜻
	}
}
