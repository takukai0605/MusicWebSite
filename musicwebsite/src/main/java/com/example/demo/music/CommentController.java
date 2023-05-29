package com.example.demo.music;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("title","音楽掲示板");
		return "view";
	}
	
	
}