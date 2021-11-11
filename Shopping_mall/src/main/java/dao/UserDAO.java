package dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import vo.UserVO;

public class UserDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//이메일 중복 체크
	public int emailCheck(String email) {
			
		int resInt = 0;
		
		UserVO vo = new UserVO();
		
		try {
			
			vo = sqlSession.selectOne("u.emailCheck", email);
			
			if(vo.getEmail() != null) {
				resInt = 1;
			}
			
		}catch (Exception e) {
			
		}
		
		return resInt;
	}
	
	//회원가입
	public int register(UserVO vo) {
		
		System.out.println("==dao 43==");
		System.out.println(vo.getEmail());
		System.out.println(vo.getPhone());
		
		int res = sqlSession.insert("u.register", vo);
		
		System.out.println("==dao 49==");
		System.out.println(res);
		
		return res;
	}
	
	//로그인
	public UserVO login(String email, String pwd) {
		
		UserVO vo = new UserVO();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("email", email);
		map.put("pwd", pwd);
		
		try {
			
			vo = sqlSession.selectOne("u.login", map);
			
		}catch (Exception e) {
			
		}
		
		System.out.println("== dao 74==");
		System.out.println(vo.getEmail());
		
		
		return vo;
	}
	
	
	
}
