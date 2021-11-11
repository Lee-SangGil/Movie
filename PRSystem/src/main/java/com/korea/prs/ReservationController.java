package com.korea.prs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReservationDAO;
import vo.ReservationVO;

@Controller
public class ReservationController {
	
	ReservationDAO reservation_dao;
	
	public void setReservation_dao(ReservationDAO reservation_dao) {
		this.reservation_dao = reservation_dao;
	}
	
	//예매
	@RequestMapping("/reservation.do")
	@ResponseBody
	public String reservation(ReservationVO vo, String type) {
		
		System.out.println(vo.getEmail());
		System.out.println(vo.getP_title());
		System.out.println(vo.getP_date());
		System.out.println(vo.getP_time());
		System.out.println(type);
		
		
		if(type == null) {
			return "{res:[{'result':'fail'}]}";
		
		}else if(type.equals("type_reservation")) {
			
			int res = reservation_dao.reservation_insert(vo);
			
			if(res == 1) {
				return "{res:[{'result':'success'}]}";
			}
		}
		
		//{res:[{"idx":42,"email":"kim@naver.com","
		return "{res:[{'result':'fail'}]}";
		
	}//reservation
	
	
	
	
	//예매내역 확인
	@RequestMapping("/reservation_list.do")
	@ResponseBody
	public List<ReservationVO> reservation_list(String email, String type) {
		
		List<ReservationVO> list = null;
		
		if(type == null) {
			
			list = new ArrayList<ReservationVO>();
			return list;
		
		}else if(type.equals("type_rev_list")) {
			
			
			list = reservation_dao.reservation_list(email);
			System.out.println("e:" + list.size());
		}
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	//예매 취소
	@RequestMapping("/reservation_del.do")
	@ResponseBody
	public String reservation_del(ReservationVO vo, String type) {
		
		System.out.println(vo.getEmail());
		System.out.println(vo.getP_title());
		
		
		if(type == null) {
			return "{res:[{'result':'fail'}]}";
		
		}else if(type.equals("type_rev_del")) {
			
			String p_title = vo.getP_title();
			String email = vo.getEmail();
			
			int res = reservation_dao.reservation_delete(email, p_title);
			
			if(res != 0) {
				return "{res:[{'result':'success'}]}";
			}
		}
		
		return "{res:[{'result':'fail'}]}";
		
	}
	
	

}
