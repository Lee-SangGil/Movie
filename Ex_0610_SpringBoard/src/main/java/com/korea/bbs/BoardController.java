package com.korea.bbs;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BoardDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {

	BoardDAO board_dao;
	
	public void setBoard_dao(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	//페이지별 게시물 조회
	@RequestMapping(value = {"/", "list.do" })
	public String list( Model model, Integer page ) {
		
		int nowPage = 1; // 기본페이지는 1로 지정
		
		if( page != null ) {
			// list.do?  <-- null인 상태
			// list.do?page=  <-- empty 상태
			nowPage = page;
		}
		
		// 한 페이지에 표시되는 게시글의 시작과 끝 번호를 계산
		// 1page : 1~5
		// 2page : 6~10
		
		int start = ( nowPage -1 ) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// start와 end를 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//게시글 전체 목록 가져오기
		
		List<BoardVO> list = board_dao.selectList(map);
		
		//전체 게시물 수 구하기
		int row_total = board_dao.getRowTotal();
		
		//paging클래스 사용하기
		String pageMenu = Paging.getPaging("list.do", 
											nowPage, 
											row_total, 
											Common.Board.BLOCKLIST,  // 페이지당 게시물 수
											Common.Board.BLOCKPAGE); // 하단 페이지 수
		
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu); // 페이지메뉴 바인딩
		
		//세션에 저장되어있던 show 정보를 제거
		request.getSession().removeAttribute("show");
		
		return Common.Board.VIEW_PATH + "board_list.jsp";
	}
	
	@RequestMapping("/view.do")
	public String view(Model model, int idx) {
		
		//idx에 해당하는 게시글
		BoardVO vo = board_dao.selectOne(idx);
		
		//조회수 증가
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			board_dao.update_readhit(idx);	
			session.setAttribute("show", "a");
		}
		
		
		//request영역에 vo를 바인딩
		model.addAttribute("vo", vo);
		
		return Common.Board.VIEW_PATH + "board_view.jsp";
	}
	
	
	//게시글 작성화면으로 전환
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		
		return Common.Board.VIEW_PATH + "board_write.jsp";
	}
	
	@RequestMapping("/insert.do")
	public String insert(Model model, BoardVO vo) {
		
		String ip = request.getRemoteAddr();
		
		//파라미터로 받은 정보를 VO에 저장
		vo.setIp(ip);
		
		board_dao.insert(vo);
		
		//내 컨트롤러안에 있는 list.do로 이동!
		return "redirect:list.do";
	}
	
	@RequestMapping("del.do")
	@ResponseBody // return된 결과값을 콜백값을 전달시켜주기 위해 사용하는 어노테이션
	public String delete(int idx, String pwd) {
		
		BoardVO baseVO = board_dao.selectOne(idx, pwd);
		
		String resultStr = "";
		String res = "no";
		
		// baseVO는 pwd가 일치하지 않을 경우 db검색이 이루어지지 않아 null값이 반환됌.
		
		if(baseVO == null) {
			resultStr = String.format("[{'res':'%s'}]", res);
			return resultStr;
		}
		
		//baseVO가 NULL이 아니면 지워도 되는 글이 검색 되었다
		baseVO.setSubject("삭제된 게시물 입니다");
		baseVO.setName("Unknown");
		
		int del_res = board_dao.del_update(baseVO);
		
		if(del_res == 1) {
			//정상적으로 업데이트가 된 경우
			res = "yes";
			resultStr = String.format("[{'res':'%s'}]", res);
		}
		return resultStr;
		
	}
	
	//댓글 작성하는 화면으로 전환
	@RequestMapping("/reply_form.do")
	public String reply_form() {
		
		return Common.Board.VIEW_PATH + "board_reply.jsp";
	}
	
	@RequestMapping("/reply.do")
	public String reply( BoardVO vo, String page ) {
		
		String ip = request.getRemoteAddr();
		
		//기준글 번호(idx)를 사용하여 댓글을 달고자 하는 게시글 정보 얻기
		BoardVO baseVO = board_dao.selectOne(vo.getIdx());
		
		//가져온 baseVO에 STEP보다 큰 값은 모두 STEP = STEP+1 처리
		board_dao.update_step( baseVO );
		
		//댓글 작성에 필요한 내용을 vo에 저장
		vo.setIp(ip);
		
		// 댓글이 들어갈 위치 지정
		vo.setRef(baseVO.getRef());
		vo.setStep(baseVO.getStep()+1);
		vo.setDepth(baseVO.getDepth()+1);
		
		//댓글목록
		board_dao.reply(vo);
		
		//페이지 정보를 수신
		return "redirect:list.do?="+page;  //response.sendRedirect("list.do?page="+page);
		
		
	}
	
}
