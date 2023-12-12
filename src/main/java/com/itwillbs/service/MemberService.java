package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

/**
 * 
 * 서비스 계층(비즈니스로직 계층) : 사용자의 요구사항을 구현하는 단계
 * 
 * => 컨트롤러 - DAO를 연결하는 계층(접착제)
 * => 외부호출이 영속계층(DB)에 종속적인 상황을 막아줌
 *
 */

public interface MemberService {
	// 구현하고자하는 동작을 추상 메서드로 선언
	public void memberJoin(MemberVO vo);
	
	public MemberVO memberLogin(MemberVO vo);
	
	public MemberVO memberInfo(MemberVO vo);
	
	public void memberUpdate(MemberVO vo);
	
	public int memberDelete(MemberVO vo);
	
	public List<MemberVO> getMemberList();
	
}
