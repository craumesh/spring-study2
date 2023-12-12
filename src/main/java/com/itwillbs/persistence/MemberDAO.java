package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

/**
 * DAO : 데이터 처리 객체 (디비 동작-Mybatis-을 제어)
 *
 */

public interface MemberDAO {
	// 회원가입 동작	
//	public void memberJoin();
	public void insertMember(MemberVO vo);
	
	// 로그인 동작
	public MemberVO selectLoginMember(MemberVO vo);
	
	// 회원정보조회 동작
	public MemberVO selectInfo(MemberVO vo);
	
	public void updateMember(MemberVO vo);
	
	public int deleteMember(MemberVO vo);
	
	public List<MemberVO> selectMemberList();
}
