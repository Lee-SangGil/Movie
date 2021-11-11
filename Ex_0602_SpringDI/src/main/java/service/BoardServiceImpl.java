package service;

import java.util.List;

import dao.BoardDAO;

public class BoardServiceImpl implements BoardService{  // BoardService 인터페이스를 구현하는 클래스
														// 인터페이스 안 함수들을 오버라이딩 해줘야 한다.
	// Service 클래스의 역할을 DAO들을 한군데 모아놓고
	// 일괄적으로 관리하기 위한 목적
	
	BoardDAO dao;   // DAO 인터페이스 타입의 객체 생성  -> 여기에 BoardDaoImpl의 주소가 넘어온다.
	
	public BoardServiceImpl( BoardDAO dao ) {   // 생성자를 만든다. 
		this.dao = dao;							// 파라미터로 BoardDAO 타입을 받아 dao에 넣어주는 역할.
	}											// 여기로 BoardDaoImpl이 넘어온다.
	
	
	@Override
	public List selectList() {	 // selectList 함수를 오버라이딩
		
		return dao.selectList();   // dao로 BoardDaoImpl의 주소가 넘어갔으니
								   // BoardDaoImpl안에 있는 selectList() 함수를 반환해준다
	}

	
}
