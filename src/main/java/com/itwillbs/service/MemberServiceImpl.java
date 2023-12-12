package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 스프링(root-context.xml)에서 해당 객체를 서비스로 인식
//				=> 서비스 객체(빈)으로 인식
@Service
public class MemberServiceImpl implements MemberService {	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;

	@Override
	public void memberJoin(MemberVO vo) {
		// 컨트롤러가 전달해준 정보를 가지고 DAO를 처리
		// DAO 객체 생성 - 회원가입 처리 메서드 호출
		logger.debug("DAO 회원가입 메서드 호출 - 시작");
		mdao.insertMember(vo);
		logger.debug("DAO 회원가입 메서드 호출 - 종료");
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// TODO Auto-generated method stub
		logger.debug("DAO 로그인 메서드 호출 - 시작");
		MemberVO resultVO = mdao.selectLoginMember(vo);
		logger.debug("DAO 로그인 메서드 호출 - 종료");
		return resultVO;
	}

	@Override
	public MemberVO memberInfo(MemberVO vo) {
		logger.debug("DAO 정보조회 메서드 호출 - 시작");
		MemberVO resultVO = mdao.selectInfo(vo);
		logger.debug("DAO 정보조회 메서드 호출 - 종료");
		return resultVO;
	}

	@Override
	public void memberUpdate(MemberVO vo) {
		logger.debug("DAO 정보수정 메서드 호출");
		mdao.updateMember(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		logger.debug("DAO 회원탈퇴 메서드 호출");
		return mdao.deleteMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("DAO 회원목록조회 메서드 호출");
		return mdao.selectMemberList();
	}	
	
}
