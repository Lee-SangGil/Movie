package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDAO{
	// 인터페이스를 구현하기 위해서는 해당 인터페이스에 있는 함수들을 다 적어줘야 한다.

	@Override
	public int insert(Object obj) {
		
		return 0;
	}

	@Override
	public List selectList() {
		// db에서 정보를 가져온것으로 가정
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("참외");
		list.add("복숭아");
		list.add("바나나");
		return list;
	}

	@Override
	public int update(Object obj) {
		
		return 0;
	}

	@Override
	public int delete(int idx) {
		
		return 0;
	}

	
}
