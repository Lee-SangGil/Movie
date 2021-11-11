package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CartVO;

public class CartDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//장바구니 등록
	public int cart_insert(CartVO vo) {
		
		System.out.println("== dao 20 ==");
		System.out.println(vo.getAmount());
		System.out.println(vo.getP_name());
		
		int res = sqlSession.insert("c.cart_insert", vo);
		
		return res;
	}
	
	//장바구니 불러오기
	public List<CartVO> cart(String cart_email){
		
		List<CartVO> list = sqlSession.selectList("c.cart", cart_email);
		
		return list;
	}
	
	
	//장바구니 삭제
	public int cart_del(int cart_idx) {
		
		int res = sqlSession.delete("c.cart_delete", cart_idx);
		
		return res;
	}
	
}






