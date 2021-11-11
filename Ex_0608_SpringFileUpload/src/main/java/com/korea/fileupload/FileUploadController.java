package com.korea.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {

	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	// 스프링으로 부터 특정 클래스 객체를 자동으로 가져오는 어노테이션
	// 단, Autowired를 사용하기 위해서는 servler-context.xml에
	// 자동주입기능을 사용할 수 있도록 코드를 추가해줘야한다!
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	// 이렇게 등록해주면 메서드에 따로 파라미터를 등록하지 않아도 메서드 내부에서 사용할 수 있다!
	
	
	//입력폼 띄우기
	@RequestMapping(value= {"/", "/insert_form.do"})
	public String insert_form() {
		
		return VIEW_PATH + "insert_form.jsp";
	}
	
	//파일업로드
	@RequestMapping("/upload.do")
	public String upload( PhotoVO vo, Model model ) {
		
		//상대경로
		String webPath = "/resources/upload/";
		
		//상대경로와 연결되는 절대경로를 지정
		String savePath = application.getRealPath(webPath);
		
		System.out.println(savePath);
		
		//업로드하기위한 파일의 정보
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		
		if(!photo.isEmpty()) {// 업로드 할 파일이 존재하는 경우
			
			//업로드 된 파일명 가져오기
			filename = photo.getOriginalFilename();
			
			//저장할 파일경로 생성
			//c:/testUpload/a.png
			File saveFile = new File(savePath, filename); 
			
			if( !saveFile.exists()) {
				saveFile.mkdirs(); // 폴더 생성
			
			}else {
				//파일명이 동일할 경우 파일을 업로드한 시간을 덧붙여서 중복 방지
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			try {
				// 업로드를 위한 파일객체는 multipartResolver클래스가
				// 지정해둔 임시 저장소에 있으므로, 이 파일을 내가 원하는 경로로'
				// 물리적으로 복사해서 넣어줘야 한다.
				photo.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "input_result.jsp";
	}
	
}
