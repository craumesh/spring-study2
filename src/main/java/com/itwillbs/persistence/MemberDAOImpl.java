package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// DB에 접근할 객체
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug("Mapper(DB) 회원가입 처리 구문 실행 - 시작");
		sqlSession.insert(NAMESPACE+".insertMember", vo);
		logger.debug("Mapper(DB) 회원가입 처리 구문 실행 - 종료");
	}

	@Override
	public MemberVO selectLoginMember(MemberVO vo) {
		logger.debug("Mapper(DB) 로그인 처리 구문 실행 - 시작");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember", vo);
		logger.debug("Mapper(DB) 로그인 처리 구문 실행 - 종료");
		logger.debug("결과 : "+resultVO);
		return resultVO;
	}

	@Override
	public MemberVO selectInfo(MemberVO vo) {
		logger.debug("Mapper(DB) 회원정보조회 처리 구문 실행 - 시작");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".getInfoMember", vo);
		logger.debug("Mapper(DB) 회원정보조회 처리 구문 실행 - 종료");
		logger.debug("결과 : "+resultVO);
		return resultVO;
	}

	@Override
	public void updateMember(MemberVO vo) {
		logger.debug("Mapper(DB) 회원정보조회 처리 구문 실행");
		sqlSession.update(NAMESPACE+".updateMember", vo);
	}

	@Override
	public int deleteMember(MemberVO vo) {
		logger.debug("Mapper(DB) 회원탈퇴 처리 구문 실행");
		return sqlSession.delete(NAMESPACE+".deleteMember", vo);
	}

	@Override
	public List<MemberVO> selectMemberList() {
		logger.debug("Mapper(DB) 회원목록조회 처리 구문 실행");
		return sqlSession.selectList(NAMESPACE+".getMemberList");
	}
	
}
