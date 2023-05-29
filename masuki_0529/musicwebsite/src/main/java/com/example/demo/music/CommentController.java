package com.example.demo.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.FormDao;
import com.example.demo.entity.EntForm;

@Controller
public class CommentController {
	
	private final FormDao formdao;
	@Autowired
	public CommentController(FormDao formdao) {
	this.formdao = formdao;
	}

	@RequestMapping("/view")
	public String view(Model model) {
		List<EntForm> list = formdao.searchDb();
		model.addAttribute("dbList",list);
		model.addAttribute("title","音楽掲示板");
		return "view";
	}
	

	@RequestMapping("/genre/J-POP")
	public String genre1(Model model) {
		List<EntForm> list = formdao.genre1Db();
		model.addAttribute("dbList",list);
		model.addAttribute("title", "J-POP");
		return "genre";
	}
	
	@RequestMapping("/genre/K-POP")
	public String genre2(Model model) {
		List<EntForm> list = formdao.genre2Db();
		model.addAttribute("dbList",list);
		model.addAttribute("title", "K-POP");
		return "genre";
	}
	
	@RequestMapping("/genre/ballad")
	public String genre3(Model model) {
		List<EntForm> list = formdao.genre3Db();
		model.addAttribute("dbList",list);
		model.addAttribute("title", "バラード");
		return "genre";
	}
	
	
	
}