package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//모든 POJO가 가지고 있어야되는 메서드
	// ? -> String 타입으로 변환
	// 데이터 베이스에서 값을 가져와 객체 바인딩 해주는 역할 까지
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException; 
		
	}
