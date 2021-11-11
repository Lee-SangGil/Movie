package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

// @Repository  데이터관리 어노테이션
// 이 어노테이션을 가지고 있는 클래스는 추후 Auto-Detecting을 통해서 자동생성이 가능해진다!

@Repository("dept_dao") //DeptDAO를 호출하기 위한 별칭
public class DeptDAO {

	//Auto Detecting으로 만든 객체는 세터, 생성자 인젝션을 사용할 수 없으므로
	//SqlSession객체는 Autowired 기능을 통해 만들어줘야 한다.
	
	@Autowired
	SqlSession sqlSession;
	
	public DeptDAO() {
		System.out.println("생성자입니다");
	}
	
	public List<DeptVO> selectList(){
		
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		return list;
	}
	
}






