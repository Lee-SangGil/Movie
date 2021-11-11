package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.GogekVO;

public class GogekDAO {

	SqlSession sqlSession;  // sqlSession 객체 생성 : sql 접근을 하기위해 
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<GogekVO> selectList(){
		
		List<GogekVO> list = sqlSession.selectList("gogek.gogek_list");
		
		return list;
	}
	
}
