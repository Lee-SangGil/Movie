package dao;

import java.util.List;

public interface BoardDAO {

	int insert( Object obj );   // 함수 정의.
	List selectList();			// insert, selectList(), update, delete
	int update( Object obj );
	int delete( Object obj );
	
}
