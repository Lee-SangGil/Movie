package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

// @ : 어노테이션(프로그래밍 주석)
@Controller // 스프링에서 해당 클래스가 Controller임을 인식시키기 위해
			// "반드시" 어노테이션이 필요하다.

			// 컨트롤러는 root context에서 객체화를 할 수 없다.

public class BoardController {

	// Controller : 외부의 요청을 받아들이기 위해서 사용하는
	// jsp의 servlet과 같은 개념
	
	BoardService service;  // BoardService 인터페이스타입의 객체 생성
	
	public void setService(BoardService service) {  // 새터생성. 파라미터 BoardService타입
		this.service = service;						// 서비스에 값을 넣기 위해.
	}
	
	public BoardController() {    // BoardController 생성자 생성
		System.out.println("==boardController의 기본 생성자==");  // 그냥 출력. 컨트롤러를 들리나 확인 하기위해.
	}
	
	// 사용자가 요청할 url매핑을 컨트롤러에서 받아줘야 한다.
	@RequestMapping("/board/list.do")
	public String list( Model model ) {
		
		//service를 거쳐 dao의 selectList()메서드를 호출
		List list = service.selectList();
		
		//바인딩
		model.addAttribute("list", list);
		
		//포워딩
		return "board_list";
	}
	
	
}













