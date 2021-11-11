package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ReservationVO;

public class ReservationDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//예매
	public int reservation_insert(ReservationVO vo) {
		
		try{
			
			int res = sqlSession.insert("r.reservation_insert", vo);
			
			return res;
					
		}catch (Exception e) {
			
			System.out.println("err:" + e.getMessage());
		}
		
		return 0;
	}
	
	//예매내역 확인
	public List<ReservationVO> reservation_list(String email) {
		
		List<ReservationVO> list = sqlSession.selectList("r.reservation_list", email);
		
		return list;
	}
	
	
	
	//예매취소
	public int reservation_delete(String email, String p_title) {
		
		System.out.println("====dao");
		System.out.println("email = " + email);
		System.out.println("p_title = " + p_title);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("email", email);
		map.put("p_title", p_title);
		
		int res = sqlSession.delete("r.reservation_delete", map);
		
		System.out.println("res = " + res);
		
		
		return res;
	}

}
