package com.boot.backendMiniProject.dao;

import java.util.HashMap;

import com.boot.backendMiniProject.model.MemberVO;

public interface IMemberDAO {
	MemberVO loginCheck(HashMap<String, Object> map); // 로그인
}
