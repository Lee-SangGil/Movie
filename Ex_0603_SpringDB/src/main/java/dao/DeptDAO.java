package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {

	SqlSession sqlSession;  // sqlSession 객체 생성
	
	public void setSqlSession(SqlSession sqlSession) { // 생성자 생성. sqlSession이 어디 sql로 접근할 것인가. 
		this.sqlSession = sqlSession; 				   // 어디 매퍼로 접근할 것인가를 받아오
	}
	
	//부서목록 
	public List<DeptVO> selectList(){
		
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");  // dept매퍼와 dept_list id를 가진 쿼리문을 실행해서
																	  // 결과 값을 list로 받음
		return list;
	}
}
