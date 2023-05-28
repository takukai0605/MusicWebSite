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
    
	//�V�K�o�^��ʕ\��
    @GetMapping("/signup")
    public String signUpForm(Model model,User user) {
    	model.addAttribute("user", new User());
        return "signup";
    }
    
    //�V�K�o�^����
    @PostMapping("/signup")
    public String signUpSubmit(@RequestParam String name, @RequestParam String password) {
        User user = new User(name, password);
        users.put(name, user);
        return "redirect:/login";
    }
    
    //���O�C����ʕ\��
    @GetMapping("/login")
    public String showloginForm() {
    	return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model,User user) {
        // ���[�U���ƃp�X���[�h�̃o���f�[�V�����Ȃǂ̃��W�b�N���������܂�
        if (isValidUser(name, password)) {
            model.addAttribute("message", "���O�C�����܂���");
            return "success";
        } else {
            model.addAttribute("error", "���[�U���܂��̓p�X���[�h������������܂���");
            return "logIn";
        }
    }

    private boolean isValidUser(String name, String password) {
        // ���[�U���ƃp�X���[�h�̃`�F�b�N���W�b�N���������܂�
        // ���̎����Ƃ��āA"admin"���[�U����"password"�p�X���[�h�𐳓��ȏ��Ƃ��܂�
        return name.equals("tanaka") && password.equals("aaa");
    }


}
