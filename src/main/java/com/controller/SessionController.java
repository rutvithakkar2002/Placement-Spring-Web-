package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {

	@GetMapping("/login")
	public String loginView() {
		return "Login";
	}

	@PostMapping("/authenticate")
	public String authenticate(@RequestParam("email") String email,@RequestParam("password") String password,Model model)
	{
		
		if(email.equals("admin@gmail.com") &&  (password.equals("admin")))
		{
			return "Home";
		}
		else
		{
			model.addAttribute("error","Invalid Credentials");
			return "redirect:/home";
		}
	}
	@GetMapping("/home")
	public String home()
	{
		return "Home";
	}
}
