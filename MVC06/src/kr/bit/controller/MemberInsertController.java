package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		
		String ctx = request.getContextPath();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao=new MemberDAO();
		int cnt = dao.memberInsert(vo);
		
		String nextPage= null;
		if(cnt>0) {
			//가입 성공
			//out.println("insert success");
			nextPage="redirect:"+ctx+"/memberList.do";
		} else {
			//가입 실패-> 예외객체를 만들어서 WAS에게 던지자.
			new ServletException("not insert");
		}
		
		return nextPage;
	}
}
