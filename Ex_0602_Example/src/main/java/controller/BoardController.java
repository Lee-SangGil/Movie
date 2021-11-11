package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

@Controller // 스프링으로 하여금 해당 클래스가 컨트롤러임을 인식시켜줘야 한다!!
public class BoardController {

	BoardService service;
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	public BoardController() {
		System.out.println("==boardController의 기본 생성자==");
	}
	
	// 사용자가 요청할 url 매핑
	@RequestMapping("/board/list.do")
	public String list() {
		
		// service를 거쳐 dao의 selectList() 함수를 호출
		List list = service.selectList();
		
		return "board_list"; // 스프링에서는 포워딩할떄 String 타입으로 이름만 저장해서 보내주면 된다.
	}
	
	
	
}
