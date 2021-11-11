package com.korea.vs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {

	@Autowired
	HttpServletRequest request; // ip구하는 용도
	
	@Autowired
	ServletContext application; // 절대경로 구하는 용도
	
	VisitDAO visit_dao;
	
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	//방명록 전체목록 조회
	@RequestMapping(value= {"/", "list.do"})  // 매핑을 아무것도 받지 않았거나, list.do를 받았을때 실행!
											  // 아무것도 안받는것은 프로젝트에 한개만 있어야 한다!
	
	public String list(Model model) {
		
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);
		
		return MyCommon.Visit.VIEW_PATH + "visit_list.jsp";
	}
	
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		
		return MyCommon.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	@RequestMapping("insert.do")
	public String insert( VisitVO vo) {
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		String webPath = "/resources/upload/";
		String savePath = application.getRealPath(webPath);
		
		//업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		
		//업로드된 파일이 존재한다면
		if(!photo.isEmpty()) {
			
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			if(!saveFile.exists()) {
				
				saveFile.mkdirs();
			
			}else {
				
				//파일이름 중복 방지
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			try {
				photo.transferTo(saveFile);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		
		//DB에 vo객체의 값들을 추가
		visit_dao.insert(vo);
		
		return "redirect:list.do"; // list.do 매핑 호출
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody // return값을 view로 인식하지 않고, 콜백메서드로 전달
	public String delete(int idx) {
		
		int res = visit_dao.delete(idx);
		
		String result = "no";
		if(res == 1) {
			result ="yes";
		}
		
		// return result;
		// result.jsp를 찾으려고한다.
		
		return result;
	}
	
	@RequestMapping("/modify_form.do")
	public String modify_form(Model model, int idx) {
		
		VisitVO vo = visit_dao.selectOne(idx);
		
		model.addAttribute("vo", vo);
		
		return MyCommon.Visit.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	
	@RequestMapping("/modify.do")
	@ResponseBody
	public String modify(HttpServletRequest request, int idx, String name, String content, String pwd) {
		
		String ip = request.getRemoteAddr();
		
		VisitVO vo = new VisitVO();
		
		vo.setIdx(idx);
		vo.setName(name);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setIp(ip);
		
		int res = visit_dao.update(vo);
		
		String result = "no";
		if(res == 1) {
			result ="yes";
		}
		
		return result;
	}
	
	
	
	
}
