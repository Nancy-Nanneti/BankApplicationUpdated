package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.entities.User;
import com.bookapp.model.entities.UserType;
import com.bookapp.model.service.UserService;
import com.bookapp.web.formbeans.UserBean;

public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("showAll")
	public ModelAndView showallusers(ModelAndView mv) {
		mv.setViewName("showallusers");
		mv.addObject("users", userService.getAllUser());
		return mv;
	}

	
	@GetMapping("deleteuser")
	public String delBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		userService.deleteUser(id);
		return "redirect:/showallusers";
	}


	@GetMapping("updateuser")
	public String addUserGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.getUserById(id);
		map.addAttribute("user", user);
		return "updateuser";
	}


	@GetMapping("adduser")
	public String addUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "adduser";
	}
	
	@PostMapping("adduser")
	public String addUserPost(@Valid @ModelAttribute("userBean") User userBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/adduser";
		} else {
			if (userBean.getUid() == 0) {
				userService.addUser(userBean);
			} else {
				userService.updateUser(userBean.getUid(), userBean);
			}
			return "redirect:/showallusers";
		}
			
	}
	
	@ModelAttribute(value = "usertypes")
	public UserType[] userType() {
		return UserType.values();
	}

}

