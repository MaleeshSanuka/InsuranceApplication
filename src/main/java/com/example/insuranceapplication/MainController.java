package com.example.insuranceapplication;

import com.example.insuranceapplication.user.User;
import com.example.insuranceapplication.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {


    @GetMapping("")
    public String showHomePage(){
        System.out.println("main controller");
        return "index";
    }

    @GetMapping("/home")
    public String viewUserList(){
        return "home";
    }
}
