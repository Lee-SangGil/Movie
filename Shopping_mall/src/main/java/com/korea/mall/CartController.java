package com.korea.mall;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CartDAO;
import vo.CartVO;

@Controller
public class CartController {

	CartDAO cart_dao;
	
	@Autowired
	HttpSession session;
	
	public void setCart_dao(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	// 장바구니에 등록
	@RequestMapping("cart_insert.do")
	@ResponseBody
	public String cart_insert(String email, String p_name, String p_price, String count) {
		
		session.setAttribute("email", email);
		
		int count1 = Integer.parseInt(count);
		
		int price = Integer.parseInt(p_price);
		
		System.out.println("== con 39==");
		System.out.println(price);
		
		int amount = count1 * price;
		
		CartVO vo = new CartVO();
		
		vo.setCart_email(email);
		vo.setP_name(p_name);
		vo.setCount(count1);
		vo.setAmount(amount);
		vo.setPrice(price);
		
		int resInt = cart_dao.cart_insert(vo);
		
		String resultStr;
		String res = "yes";
		
		if(resInt == 0) {
			res = "no";
		}
		
		resultStr = String.format("[{'res':'%s'}]", res);
		
		return resultStr;
	}
	
	
	// 장바구니 목록 불러오기
	@RequestMapping("cart.do")
	public String cart(String cart_email, Model model) {
		
		session.setAttribute("email", cart_email);
		
		List<CartVO> list = cart_dao.cart(cart_email);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/cart/cart.jsp";
	}
	
	
	//장바구니 삭제
	@RequestMapping("cart_del.do")
	@ResponseBody
	public String cart_del(int cart_idx, String email) {
		
		session.setAttribute("email", email);
		
		int resInt = cart_dao.cart_del(cart_idx);
		
		String resultStr;
		String res = "yes";
		
		if(resInt == 0) {
			res = "no";
		}
		
		resultStr = String.format("[{'res':'%s'}]", res);
		
		return resultStr;
	}
	
	
	
	
}













