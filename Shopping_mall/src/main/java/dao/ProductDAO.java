package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;
import vo.Product_RevVO;
import vo.UserVO;



public class ProductDAO {
	
	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//메인페이지 상품리스트
	public List<ProductVO> list() {
		
		List<ProductVO> list = sqlSession.selectList("p.list");
		
		return list;
	}
	
	//상품 상세 정보
	public List<ProductVO> product_detail(String p_name) {
		
		System.out.println("==dao 36 ==");
		System.out.println(p_name);
		
		List<ProductVO> list = sqlSession.selectList("p.product_detail", p_name);
		
		return list;
	}
	
	
	//상품 리뷰
	public List<Product_RevVO> product_review(String p_name) {
			
		List<Product_RevVO> list = sqlSession.selectList("p.product_review", p_name);
		
		return list;
	}
	
	
}
