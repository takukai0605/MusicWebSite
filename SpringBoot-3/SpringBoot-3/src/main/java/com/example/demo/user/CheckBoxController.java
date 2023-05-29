package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckBoxController {
	@RequestMapping("/index1")
	public String top(Model model) {
		model.addAttribute("title", "掲示板新規作成");
		return "index1";
	}
	
}