package com.cydeo.controller;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserDTO());
//        model.addAttribute("roles", find all roles from db); // we will get roles from database for "roles" for create.html line 104 with help of service package
        // we will create interface for role in service package




        return "user/create";
    }

}
