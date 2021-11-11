package dao;

import org.apache.ibatis.session.SqlSession;

import vo.AndVO;

public class AndDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//회원가입
	public int insert(AndVO vo) {
		
		try {
			
			int res = sqlSession.insert("a.user_insert", vo);
			return res;
					
		}catch (Exception e) {
			
		}
		return 0;
	}
	
	//로그인
	public AndVO selectOne(AndVO vo) {
		
		AndVO res = sqlSession.selectOne("a.login", vo);
		
		return res;
	}

}
