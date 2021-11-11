package service;

import java.util.List;

import dao.BoardDAO;
import dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService{

	// Service클래스의 역할은 DAO들을 한군데 모아놓고
	// 일괄적으로 관리하는 위한 목적
	
	BoardDAO dao;
	
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List selectList() {
		
		return dao.selectList();
	}

	
}
