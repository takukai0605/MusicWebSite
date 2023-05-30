package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SerchDao;
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
		model.addAttribute("title", "一覧ページ");
		return "search";
	}
	
	@RequestMapping("/comment")
	public String view() {
		return "comment";
	}
	
	
}
