package com.korea.mall;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import dao.ProductDAO;
import vo.ProductVO;
import vo.Product_RevVO;
import vo.UserVO;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO product_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	public void setProduct_dao(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}
	
	//메인페이지, 상품리스트
	@RequestMapping(value={"/", "/list.do"})
	public String product_list(String email, Model model) {
		
		List<ProductVO> list = product_dao.list();
		
		model.addAttribute("list", list);
		session.setAttribute("email", email);
		
		return "/WEB-INF/views/main/main.jsp";
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("email");
		session.invalidate();
		
		return "redirect:list.do";
	}
	
	
	//상품 상세 리스트
	@RequestMapping("product_detail.do")
	public String product_detail(String p_name, Model model) {
		
		System.out.println("== pro con 64==");
		System.out.println(p_name);
		
		List<ProductVO> list = product_dao.product_detail(p_name);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/main/product_detail.jsp";
	}
	
	
	// 상품 리뷰 리스트
	@RequestMapping("product_review.do")
	public String product_review(String p_name, String email, Model model) {
			
		List<Product_RevVO> list = product_dao.product_review(p_name);
		
		model.addAttribute("list", list);
		session.setAttribute("email", email);
		
		return "/WEB-INF/views/main/product_review.jsp";
	}
	
	
	
	
}
