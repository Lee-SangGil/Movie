package dao;

import org.apache.ibatis.session.SqlSession;

import vo.VincentVO;

public class VincentDAO {
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public String register( VincentVO vo ) {
		
		try {
			
			sqlSession.insert("v.insert_vincent", vo);
			return "{res:[{'result':'success'}]}";
			
		}catch (Exception e) {
			return "{res:[{'result':'fail'}]}";
		}
		
	}
	
	
	public String login(VincentVO vo) {
		
		String res = "fail";
		
		try {
			
			VincentVO vinuser = sqlSession.selectOne("v.login_vincent",vo);
			
			if( vinuser.getEmail() != null && vinuser.getPwd() != null) {

				res = "success";

			}
			
		}catch(Exception e) {
			
		}
		
		return res;
	
	}
	
}
	

