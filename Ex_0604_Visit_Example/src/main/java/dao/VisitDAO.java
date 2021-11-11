package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<VisitVO> selectList(){
		
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		
		return list;
		
	}
	
	
	
	
}





