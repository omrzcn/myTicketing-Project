package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
private final RoleService roleService;
private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserDTO()); // we need to provide empty page for UI. user will fill it.
     model.addAttribute("roles", roleService.findAll()); // we will get roles from database for "roles" for create.html line 104 with help of service package
        // we will create interface for role in service package
        model.addAttribute("users",userService.findAll()); // this is for userList on the page.




        return "/user/create";
    }


    @PostMapping("/create")
    public String insertUser(@Valid @ModelAttribute("user") UserDTO user,BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {

            model.addAttribute("roles", roleService.findAll());
            model.addAttribute("users", userService.findAll());

            return "/user/create";
        }

        userService.save(user);


        return "redirect:/user/create";
    }


    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        // finding user according to "id"
        model.addAttribute("user",userService.findById(username));
        // again bring all "roles"
        model.addAttribute("roles",roleService.findAll());
        // again bring all userlist
        model.addAttribute("users",userService.findAll());

        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult,Model model){ // we provided UserDTO userDTO , thats why we dont have to provide @ModelAttribute("user"). Inteellij will understand

        if (bindingResult.hasErrors()){
            model.addAttribute("roles",roleService.findAll());
            model.addAttribute("users",userService.findAll());

            return "/user/update";
        }

        // we updated this user by @ModelAttribute
        userService.update(userDTO);

        return "redirect:/user/create";
    }


    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){

        userService.deleteById(username);

        return "redirect:/user/create";
    }


}







