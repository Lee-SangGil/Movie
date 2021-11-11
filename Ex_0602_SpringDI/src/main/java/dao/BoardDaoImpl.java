package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDAO{  // BoardDAO를 구현하는 클래스
												// BoardDAO안에 있는 함수들을 오버라이딩으로 다 받아줘야 쓸 수 있다.
	@Override
	public int insert(Object obj) {   // DAO에서 정의해준 파라미터 타입과 같게 작성.
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectList() {
		// DB에서 정보를 가지고 온 것으로 가정
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
