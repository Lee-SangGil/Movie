package dao;

import java.util.List;

public interface BoardDAO {

	// 나중에 사용할 것 같은 메서드를 추상으로 등록
	// C R U D
	// 파라미터로 무엇을 받을지 모르면 우선 Object 타입으로 만들면 된다.
	
	int insert( Object obj );   // create 개념
	List selectList();  // read 개념
	int update( Object obj);  // update
	int delete(int idx);   // delete
	
	// 이 추상들을 구현할 수 있는 자식 클래스를 만들어 준다.
	
	
	
}
