package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

public class LogoutController {

	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}

}
