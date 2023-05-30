package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.EntForm2;
import com.example.demo.model.User;



@Controller
public class UserController {
	  //UserDao�̗p��
  	private final UserDao userdao;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message","音楽掲示板");
		return "home";
	}
    
	//�V�K�o�^��ʕ\��
    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute User user) {
        return "signup";
    }
    
    //�V�K�o�^����
    @PostMapping("/signup")
    public String signUpSubmit(User user,Model model) {
    	System.out.println("Received User: " + user);
    	EntForm2 entform = new EntForm2();
  		entform.setName(user.getName());
  		entform.setPassword(user.getPassword());
  		userdao.insertDb(entform);
        return "login";
    }
    
    //���O�C����ʕ\��
    @GetMapping("/login")
    public String showloginForm() {
    	return "login";
    }
    
    @PostMapping("/login")
    public String login(Model model,EntForm2 entform) {
        // ���[�U���ƃp�X���[�h�̌���
    	List<EntForm2> list = userdao.searchDb();
    	boolean isValid = false;

        for (EntForm2 dbUser : list) {
            if (dbUser.getName().equals(entform.getName()) && dbUser.getPassword().equals(entform.getPassword())) {
                isValid = true;
                break;
            }
        }
        if (isValid) {
            model.addAttribute("message", "���O�C�����܂���");
            return "success";
        } else {
            model.addAttribute("error", "���[�U���܂��̓p�X���[�h������������܂���");
            return "logIn";
        }
    }

  	@Autowired
  	public UserController(UserDao userdao) {
  		this.userdao = userdao;
  	}



}
