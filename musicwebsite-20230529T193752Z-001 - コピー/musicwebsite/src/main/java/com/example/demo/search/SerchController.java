package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SerchDao;
import com.example.demo.entity.InputSearch;
import com.example.demo.entity.SerchEnt;


@Controller
public class SerchController {
	private final SerchDao sampledao;

	@Autowired
	public SerchController(SerchDao sampledao) {
		this.sampledao = sampledao;
	}

	@RequestMapping("/search")
	public String view(Model model) {
		List<SerchEnt> list = sampledao.searchDb();
		model.addAttribute("dbList", list);
		return "takuma/search";
	}
	
	@RequestMapping("/comment")
	public String view(InputSearch input) {
		return "takuma/comment";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "takuma/test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "takuma/test2";
	}
}
