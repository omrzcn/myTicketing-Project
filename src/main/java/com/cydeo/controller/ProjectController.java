package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers",userService.findManager());// this is coming from UserService. we created findManager to only see managers on the dropdown.
        model.addAttribute("projects",projectService.findAll());
        return "/project/create";
    }


    @PostMapping("/create")
    public String insertProject(@ModelAttribute ("project") ProjectDTO project){


        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode){

        projectService.deleteById(projectcode);

        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}") // we created this to get complete.
    public String completeProject(@PathVariable("projectCode") String projectCode){

        projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/create";
    }


    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode,Model model){
        model.addAttribute("project",projectService.findById(projectCode));
        model.addAttribute("managers",userService.findManager());
        model.addAttribute("projects",projectService.findAll());



        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project){

        projectService.save(project);

        return "redirect:/project/create";
    }




}
