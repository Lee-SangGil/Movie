package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVO;

public class SawonDAO {

	SqlSession sqlSession;  // sqlSession 객체 생성
	
	//public void setSqlSession(SqlSession sqlSession) {
	//	this.sqlSession = sqlSession;
	//}
	
	public SawonDAO(SqlSession sqlSession) {  // 생성자 인젝션 
		this.sqlSession = sqlSession;
	}
	
	public List<SawonVO> selectList(){
		
		List<SawonVO> list = sqlSession.selectList("sawon.sawon_list");  //sawon.xml에서 
																		 //sawon name space, sawon_list로 접근
		
		return list;
	}
}
