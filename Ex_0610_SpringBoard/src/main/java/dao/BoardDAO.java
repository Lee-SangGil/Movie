package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

import vo.BoardVO;

public class BoardDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	//전체 게시물 조회
	public List<BoardVO> selectList(){
		
	
		List<BoardVO> list = sqlSession.selectList("b.board_list");
		
		
		return list;
	}
	
	//새글 추가
	public int insert(BoardVO vo) {

		int res = sqlSession.insert("b.board_insert", vo);

		return res;
	}
	
	public BoardVO selectOne(int idx) {
		
		BoardVO vo = sqlSession.selectOne("b.board_one", idx);
			
		return vo;
	}
	
	
	//클릭한 게시물의 조회수 증가
	
	public int update_readhit( int idx ) {
		
		int res = sqlSession.update("b.board_update_readhit", idx);
		
		return res;
	}
	
	
	public int update_step(BoardVO vo) {
		
		int res = sqlSession.update("b.board_update_step", vo);
		
		return res;
	}
	
	public int reply(BoardVO vo) {
		
		int res = sqlSession.insert("b.board_reply", vo);
		
		return res;
	}
	
	public BoardVO selectOne(int idx, String pwd) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("idx", idx);
		map.put("pwd", pwd);
		
		BoardVO vo = sqlSession.selectOne("b.board_idx_pwd", map);
		
		return vo;
	}
	
	//게시글 삭제(된것 처럼 update)
	public int del_update(BoardVO vo) {
		
		int res = sqlSession.update("b.board_del_update", vo);
				
		return res;
	}
	
	//페이지별 게시물 조회
	public List<BoardVO> selectList(HashMap<String, Integer> map){
		
		List<BoardVO> list = sqlSession.selectList("b.board_list_page", map);
		
		return list;
	}
	
	//전체 게시물의 갯수
	public int getRowTotal() {
		
		int count = sqlSession.selectOne("b.board_count");
		
		return count;
	}
	
}









