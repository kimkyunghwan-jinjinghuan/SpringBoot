package com.example.basic.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.basic.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IPCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("filter begin");
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 세션의 유저정보 확인 후 처리 
		HttpSession session = req.getSession();
		//자식은 언제나 부모로 변신가능 트럭->카, 택시->카 
		//세션에는 몯느 자료형태를 담을 수 있으므로 Object형태로 저장
//		User user = (User) session.getAttribute("user");
//		if( user == null) {
//			HttpServletResponse resp = (HttpServletResponse)response;
//			resp.sendRedirect("/login");
//		}
		
		
		String ip = request.getRemoteAddr();
		log.debug("ip : " + ip);
		chain.doFilter(req, response);
		log.debug("filter end");
	}
}
//로그인하는 사람들 ip체크