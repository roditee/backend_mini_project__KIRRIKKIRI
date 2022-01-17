package com.boot.backendMiniProject.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.backendMiniProject.model.MemberVO;
import com.boot.backendMiniProject.service.MemberService;

@Controller
public class MemberController {
	// DI 설정
	@Autowired
	MemberService service;
	
	// 로그인 처리
	@ResponseBody
	@RequestMapping("/loginCheck")
	public String loginCheck(@RequestParam HashMap<String, Object> param, Model model,
											HttpSession session) {
		// 로그인 체크
		MemberVO vo = service.loginCheck(param);
		String result = "fail";
		if(vo!=null) {
			// 로그인 성공 시 세션 변수 지정
			session.setAttribute("sid", vo.getMemId());
			result ="success";
		}
		return result;
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 사용자 아이디 중복 확인
	@ResponseBody
	@RequestMapping("/memIdCheck")
	public String memIdCheck(@RequestParam("memId") String memId) {
		String memId_result = service.memIdCheck(memId);
		
		String result = "use";
		if(memId_result != null)
			result = "no_use";
		
		return result;
	}
	
	// 사용자 아이디 중복 확인
	@ResponseBody
	@RequestMapping("/memEmailCheck")
	public String memEmailCheck(@RequestParam("memEmail") String memEmail) {
		String memEmail_result = service.memEmailCheck(memEmail);
		
		String result = "use";
		if(memEmail_result != null)
			result = "no_use";
		
		return result;
	}
	
	// 회원가입
	@RequestMapping("/memJoin")
	public String memJoin(MemberVO vo) {
		service.memJoin(vo);
		return "redirect:/";
	}
}