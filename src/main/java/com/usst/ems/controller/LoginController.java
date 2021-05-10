package com.usst.ems.controller;

import com.usst.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

//    @RequestMapping("/list")
//    public String index(){
//        return "list";
//    }
//    @RequestMapping("/dashboard")
//    public String index1(){
//        return "dashboard";
//    }
    @Autowired
    EmployeeService employeeService ;
    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){
        int exist=employeeService.getUserByUsername(username,password);
//        System.out.println(exist);
        if (exist==1){
            //存在用户
            session.setAttribute("user",username);
            return "redirect:/main";
        }
        //不存在用户
        model.addAttribute("msg","用户名或密码错误");
        return "index";
    }

}
