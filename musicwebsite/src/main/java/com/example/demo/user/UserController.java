package com.example.demo.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {
@RequestMapping("/")
public String top(Model model) {
model.addAttribute("title", "新規登録");
return "index";
}
}