package com.boot.backendMiniProject.dao;

import java.util.HashMap;

import com.boot.backendMiniProject.model.MemberVO;

public interface IMemberDAO {
	MemberVO loginCheck(HashMap<String, Object> map); // 로그인
	String memIdCheck(String memId); // id 중복 확인
	String memEmailCheck(String email); // 이메일 중복 확인
	void memJoin(MemberVO vo); // 회원가입
}
