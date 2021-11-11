package dao;

import org.apache.ibatis.session.SqlSession;

import vo.UserVO;

public class UserDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public String register(UserVO vo) {
		
		int n = 0;
		String res = "";
		
		try {
			
			n = sqlSession.insert("u.insert",vo);
			return "res:[{'result','success'}]";
			
		}catch(Exception e) {
			
			return "res:[{'result','fail'}]";
		}
		
		
	
	}
	
	

}
