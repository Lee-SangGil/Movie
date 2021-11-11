package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DeptDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<DeptDAO> selectList(){
		
		List<DeptDAO> list = sqlSession.selectList("dept.dept_list");
	
		return list;
	}
	
	
}
