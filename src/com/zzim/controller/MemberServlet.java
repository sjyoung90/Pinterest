package com.zzim.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzim.controller.MemberController;
import com.zzim.dao.MemberDAO;
import com.zzim.dto.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/index.do/*")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * 디스패칭
     */
    public void callView(HttpServletRequest request, HttpServletResponse response, String viewName) throws ServletException, IOException{
    	RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
    }
    
    /*
	 * 에러 메시지 처리
	 */
	public void errorMessage(HttpServletResponse response, String error) throws IOException{
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('" + error + "')");
		out.println("history.back()");
		out.println("</script>");
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet start");
		String RequestURI = request.getRequestURI();
    	String command = RequestURI.substring(RequestURI.lastIndexOf("/")+1);
    	System.out.println(command);
    	
    	/*
    	 * 로그인
    	 */
    	if(command.equals("") || command.equals("login")){
    		
    		HttpSession session = request.getSession();
    		String sessionId = (String)session.getAttribute("id");
    		
    		if(sessionId != null){
    			System.out.println("세션이 있습니다.");
    			response.sendRedirect(request.getContextPath() + "/member.do/main");
    		}
    		else {
    			//쿠키 확인
        		Cookie[] cookies = request.getCookies();
        		String idCookie = "";
        		if(cookies != null){
        			for(int i=0; i<cookies.length; i++){
        				if(cookies[i].getName().equals("id")){
        					idCookie = cookies[i].getValue();
        					break;
        				}
        			}
        		}
        		System.out.println(idCookie);
        		request.setAttribute("cookie", idCookie);

        		callView(request, response, "/login.jsp");
    		}
    	}
    	/*
    	 * 중복확인
    	 */
    	else if(command.equals("dupliID")){
    		callView(request, response, "/dupliCheck.jsp");
    	}
    	/*
    	 * 회원가입
    	 */
    	else if(command.equals("join")){
    		callView(request, response, "/join.jsp");
    	}
    	/*
    	 * 내 정보 보기
    	 */
    	else if(command.equals("myInfo")){
    		
    		String id = (String) request.getAttribute("u_id");
    		
    		MemberDAO md = new MemberDAO();
    		Member member;
			member = md.getMember(id);
				
			request.setAttribute("id", member.getId());
	    	request.setAttribute("name", member.getName());
	    	request.setAttribute("gender", member.getGender());
	    	request.setAttribute("birthDate", member.getB_date());

    		callView(request, response, "/myInfo.jsp");
    	}
    	/*
    	 * 로그아웃
    	 */
    	else if(command.equals("logout")){
    		HttpSession session = request.getSession(false);
    		session.invalidate();
    		
    		//초기 로그인 페이지로 이동
    		response.sendRedirect("/SJY/index.do/login");
    	}
    	/*
    	 * 정보 수정
    	 */
    	else if(command.equals("modify")){
    		response.sendRedirect("myInfo");
    	}
    	/*
    	 * 회원 탈퇴
    	 */
    	else if(command.equals("delete")){
    			callView(request, response, "/deleteCheck.jsp");
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberController mc = new MemberController();
		
		System.out.println("doPost start");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
    	String RequestURI = request.getRequestURI();
    	String command = RequestURI.substring(RequestURI.lastIndexOf("/")+1);
    	System.out.println("LoginServlet doPost command : " + command);
    	
    	if(command.equals("login")){
    		String id = request.getParameter("userID");
    		String passwd = request.getParameter("userPW");
    		String cookie = request.getParameter("cookie");

    		/*
    		 * 쿠키 설정
    		 */
    		Cookie idCookie = null;
    		if(cookie != null && cookie.equals("on")) {
    			idCookie = new Cookie("id", id);
    			idCookie.setMaxAge(60*60*24*30); //1개월동안 쿠키 저장
    		}
    		else {
    			idCookie = new Cookie("id", "");
    			idCookie.setMaxAge(0);
    		}		
    		response.addCookie(idCookie);
    		
    		/*
    		 * 로그인 체크
    		 */
    		try {
				if(mc.checkMember(id, passwd).equals("loginSuccess")){  //로그인 성공
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setMaxInactiveInterval(60*10); //10분간 세션 유지

					response.getWriter().write("loginSuccess");
				}
				else if(mc.checkMember(id, passwd).equals("pwFail")){
					errorMessage(response, "비밀번호가 일치하지 않습니다.");
					
					response.getWriter().write("pwFail");
				}
				else {
					errorMessage(response, "존재하지 않는 아이디입니다.");
					
					response.getWriter().write("idFail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
    	}
    	
    	/*
    	 * 회원가입 체크
    	 */
    	else if(command.equals("join")){
    		Member member = new Member(request.getParameter("u_id"), 
				    				   request.getParameter("u_pw"), 
				    				   request.getParameter("u_name"),
				    				   request.getParameter("u_gender"),
				    				   request.getParameter("u_birthDate"));
    		
    		try {
				if(mc.joinMember(member) == true) {
					//callView(request, response, "/joinSuccess.jsp");
				}
				else {
					errorMessage(response, "회원가입에 실패하였습니다. 다시 확인해주세요.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	/*
    	 * 아이디 중복확인
    	 */
    	else if(command.equals("dupliID")) {
    		String id = request.getParameter("u_id");
    		try {
				if(!(mc.dupliCheck(id))){
					errorMessage(response, "사용 가능한 아이디입니다.");
				}
				else{
					errorMessage(response, "중복된 아이디입니다. 다른 아이디를 입력하세요.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	/*
    	 * 회원 정보 수정
    	 */
    	if(command.equals("modify")){
    		Member member = new Member(request.getParameter("u_id"), 
					 				   request.getParameter("u_pw"), 
					 				   request.getParameter("u_name"),
					 				   request.getParameter("u_gender"),
					 				   request.getParameter("u_birthDate"));
    		try {
				if(mc.updateMember(member) == true) { //수정 완료
					callView(request, response, "/modifySuccess.jsp");
				}
				else {
					errorMessage(response, "수정에 실패하였습니다. 정보를 다시 확인해주세요.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	/*
    	 * 회원 탈퇴
    	 */
    	else if(command.equals("delete")){

    		String id = request.getParameter("u_id");
    		String pw = request.getParameter("u_pw");
    		if(pw == null){
    			errorMessage(response, "비밀번호를 입력해주세요.");
    		} else
				try {
					if(mc.checkPW(id, pw) == true){
						
						mc.deleteMember(id);
						
						HttpSession session = request.getSession();
						session.removeAttribute("id");
						session.setMaxInactiveInterval(-1);
						
						session.invalidate(); //세션 종료
						
						callView(request, response, "/deleteMember.jsp");
					}
					else{
						//에러
						errorMessage(response, "탈퇴가 정상적으로 처리되지 않았습니다.");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	}
	}

}
