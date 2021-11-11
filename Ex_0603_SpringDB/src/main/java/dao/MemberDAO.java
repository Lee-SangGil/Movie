package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MemberVO> selectList(){
		
		List<MemberVO> list = sqlSession.selectList("member.member_list");
		
		return list;
	}
	
	
	
}
