package util;

public class Common {

	//게시판이 여러개 있을때를 대비해 게시판 별로 한페이지당 몇개씩 게시물을 보여줄것인가를 지정하는 클래스
	
	//일반게시판
	public static class Board{
		
		public static final String VIEW_PATH = "/WEB-INF/views/board/";
		
		public final static int BLOCKLIST = 5;
		
		//한 화면에 보여질 페이지 메뉴 수
		// <- 1 2 3 ->
		public final static int BLOCKPAGE = 3;
		
	}
	
	//질문게시판
	public static class Qna{
		public final static int BLOCKLIST = 10;
		
		//한 화면에 보여질 페이지 메뉴 수
		// <- 1 2 3 4 5->
		public final static int BLOCKPAGE = 5;
	}
}














