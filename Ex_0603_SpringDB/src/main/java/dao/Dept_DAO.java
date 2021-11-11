package dao;

import org.apache.ibatis.session.SqlSession;

public class Dept_DAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
}
