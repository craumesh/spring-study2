package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;
import com.mysql.cj.Session;

@Controller
@RequestMapping(value = "/members/*")
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체 주입
	@Inject
	private MemberService mService;
	
	// http://localhost:8088/members/join	
	// 회원가입 (정보입력)
	@RequestMapping(value = "/join", method = RequestMethod.GET) // => GET(사용자에게 정보를 입력 받거나 보여준다)
	public void memberJoinGET() {
		logger.debug("/members/join 호출 -> memberJoinGET() 호출");
		// 연결된 뷰페이지로 이동
		logger.debug("/views/members/join.jsp페이지로 이동");
	}
	
	// 회원가입 (정보처리)
	@RequestMapping(value = "/join", method = RequestMethod.POST) // => POST(DB 데이터 관련)
	public String memberJoinPOST(/* @ModelAttribute 생략 */ MemberVO vo) {
		logger.debug("memberJoinPOST() 호출");
		// 한글처리(인코딩 설정) => 필터
		// 전달정보 저장
		logger.debug("vo : "+vo);
		
		// DB에 정보를 저장
		logger.debug("서비스 회원가입 동작을 호출 - 시작");
		mService.memberJoin(vo);
		logger.debug("서비스 회원가입 동작을 호출 - 종료");
		
		// 페이지 이동(로그인 페이지-/members/login)		
		return "redirect:/members/login";
	}

	// http://localhost:8088/members/login	
	// 로그인 - 정보 입력(GET)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug("/members/login 호출 -> memberLoginGET() 실행");
		// 연결된 뷰페이지로 이동
		logger.debug("/views/members/login.jsp페이지로 이동");
	}
	
	// 로그인 - 정보 처리(POST)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo, HttpSession session) {
		logger.debug("/members/login post 방식 호출 -> memberLoginPOST() 호출");
		// 전달정보 저장(파라미터-userid,userpw)
		logger.debug("vo : "+vo);
		// DB접근 -> 서비스접근 - 로그인 처리
		MemberVO resultVO = mService.memberLogin(vo);
		
		// 로그인 결과에 따른 페이지 이동			
		if(resultVO != null) {
			// 성공 -> 메인페이지 리다이렉트 호출(redirect:/members/main) & 세션에 아이디정보 저장
			logger.debug("로그인 성공");
			session.setAttribute("id", resultVO.getUserid());
			return "redirect:/members/main";
		}
		// 실패 -> 로그인페이지 리다이렉트 호출(redirect:/members/login)
		logger.debug("로그인 실패");
		return "redirect:/members/login";
	}	
	
	// 메인 - 정보 입력(GET)
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void memberMainGET() {
		logger.debug("/members/main 호출 -> memberMainGET() 실행");
		// 연결된 뷰페이지로 이동
		logger.debug("/views/members/main.jsp페이지로 이동");
	}
	
	// 로그아웃	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.debug("/members/logout 호출 -> memberLogoutGET() 실행");
		session.invalidate();
		return "redirect:/members/main";
	}
	
	// 회원정보 조회
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void memberInfoGET(HttpSession session, Model model) {
		logger.debug("/members/info 호출 -> memberInfoGET() 실행");
		
		// ID정보를 받아오기(세션영역)
		MemberVO vo = new MemberVO();
		String userid = (String) session.getAttribute("id");
		vo.setUserid(userid);
		// 서비스 -> id를 사용해서 회원정보 모두 조회
//		MemberVO resultVO = mService.memberInfo(vo);
//		// DB에서 조회된 결과를 view 페이지로 전달
//		model.addAttribute("vo",resultVO);
		
		model.addAttribute(mService.memberInfo(vo));
		
		// 페이지로 이동(/members/info.jsp)
	}
	
	// 회원정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void memberUpdateGET(HttpSession session, Model model) {
		logger.debug("/members/update 호출 -> memberUpdateGET() 실행");
		MemberVO vo = new MemberVO();
		String userid = (String) session.getAttribute("id");
		vo.setUserid(userid);
		model.addAttribute(mService.memberInfo(vo));		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdatePOST(MemberVO vo) {
		logger.debug("/members/update 호출 -> memberUpdatePOST() 실행");
		logger.debug("수정할 정보 : " +vo);
		mService.memberUpdate(vo);
		return "redirect:/members/info";
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void memberDeleteGET(HttpSession session) {
		logger.debug("/members/delete 호출 -> memberDeleteGET() 실행");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String memberDeletePOST(HttpSession session, MemberVO vo) {
		logger.debug("/members/delete 호출 -> memberDeletePOST() 실행");
		int result = mService.memberDelete(vo);
		if(result == 1) {
			session.invalidate();
		} else {
			return "redirect:/members/delete";
		}
		
		return "redirect:/members/main";
	}	
	
	// 회원 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void memberListGET(Model model) {
		logger.debug("/members/list 호출 -> memberListGET() 실행");
		model.addAttribute(mService.getMemberList());
		// 이름이 생략된 경우 memberVOList로 호출가능
	}
	
}
