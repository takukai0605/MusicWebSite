package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;



@Controller
@RequestMapping("/user")
public class UserController {
	
private Map<String, User> users = new HashMap<>();
    
	//新規登録画面表示
    @GetMapping("/signup")
    public String signUpForm(Model model,User user) {
    	model.addAttribute("user", new User());
        return "signup";
    }
    
    //新規登録処理
    @PostMapping("/signup")
    public String signUpSubmit(@RequestParam String name, @RequestParam String password) {
        User user = new User(name, password);
        users.put(name, user);
        return "redirect:/login";
    }
    
    //ログイン画面表示
    @GetMapping("/login")
    public String showloginForm() {
    	return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model,User user) {
        // ユーザ名とパスワードのバリデーションなどのロジックを実装します
        if (isValidUser(name, password)) {
            model.addAttribute("message", "ログインしました");
            return "success";
        } else {
            model.addAttribute("error", "ユーザ名またはパスワードが正しくありません");
            return "logIn";
        }
    }

    private boolean isValidUser(String name, String password) {
        // ユーザ名とパスワードのチェックロジックを実装します
        // 仮の実装として、"admin"ユーザ名と"password"パスワードを正当な情報とします
        return name.equals("tanaka") && password.equals("aaa");
    }


}
