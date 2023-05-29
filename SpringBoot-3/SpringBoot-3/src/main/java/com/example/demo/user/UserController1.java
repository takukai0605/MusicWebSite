package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserDao1;

@Controller
public class UserController1 {
	private final UserDao1 userdao1;
	@Autowired
	public UserController1(UserDao1 userdao1) {
		this.userdao1 = userdao1;
	}
	@RequestMapping("/")
	public String top(Model model) {
		model.addAttribute("title", "新規登録");
		return "signup";
	}
	  @PostMapping("/signup")
	    public String signUpSubmit(User1 user,Model model) {
	    	System.out.println("Received User: " + user);
	    	EntForm1 entform = new EntForm1();
	  		entform.setName(user.getName());
	  		entform.setComment(user.getPassword());
	  		userdao1.insertDb(entform);
	        return "index";
	
}
}