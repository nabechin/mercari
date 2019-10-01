package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String login() {
		return "login";
	}

	@RequestMapping("/insert")
	public String insert(@Validated UserForm form, BindingResult result) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		if (service.findByEmail(user.getEmail()) != null) {
			result.rejectValue("email", "", "すでに使われているメールアドレスです");
		}
		if (result.hasErrors()) {
			return "register";
		}
		service.insert(user);
		return "login.html";
	}

	@RequestMapping("/toLogin")
	public String toLogin(Model model, @RequestParam(required = false) String error) {
		System.err.println("login error:" + error);
		if (error != null) {
			System.err.println("login failed");
			model.addAttribute("errorMessage", "error:failed to login");
			System.out.println(error);
		}
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	

}
