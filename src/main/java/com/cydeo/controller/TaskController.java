package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task",new TaskDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployee());
        model.addAttribute("tasks",taskService.findAll());
        // i will continue with creating findEmployee.


        return "task/create";
    }


//    @PostMapping("/create")
//    public String insertTask(  @ModelAttribute("task") TaskDTO task,BindingResult bindingResult,Model model){ // burda kaldik
//        if (bindingResult.hasErrors()){
//            model.addAttribute("projects",projectService.findAll());
//            model.addAttribute("employees",userService.findEmployee());
//            model.addAttribute("tasks",taskService.findAll());
//
//            return "/task/create";
//        }
//
//            taskService.save(task);
//
//            return "redirect:/task/create";
//    }


    @PostMapping("/create")
    public String insertTask(TaskDTO taskDTO){

        taskService.save(taskDTO);

        return "redirect:/task/create";
    }


    @GetMapping("/delete/{taskId}")
    public String deleteUSer(@PathVariable("taskId") Long taskID ){

        taskService.deleteById(taskID);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id,  Model model){

        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployee());
        model.addAttribute("tasks",taskService.findAll());

        return "/task/update";
    }

    //    @PostMapping("/update/{taskId}")
//    public String updateTask(@PathVariable("taskId") Long taskId, TaskDTO task) {
//
//        task.setId(taskId);
//        taskService.update(task);
//
//        return "redirect:/task/create";
//
//    }



    //this code and above code are same.
    @PostMapping("/update/{id}") // if this "id" is exactly same name with TaskDTO class, then we dont have to write @PathVariable. This is power of Spring
    public String updateTask( TaskDTO task){
        // when i clik save button after click update, there is not gonna be id. that's why its gonna give error. We need to define BindingResulr interface.

        taskService.save(task);
        return "redirect:/task/create";
    }




    // for pending task

    @GetMapping("/employee/pending-tasks")
    public String employeePendingTask(Model model){
        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETED));
        //findAllTasksByStatusIsNot we created this because we try to find uncompleted tasks.
        return "/task/pending-tasks";



    }

    @GetMapping("/employee/archive")
    public String employeeArchive(Model model){

        // we are gonna show here all the completed task
        model.addAttribute("tasks", taskService.findAllTasksByStatus(Status.COMPLETED));


        return "/task/archive";
    }


    @GetMapping("/employee/edit/{id}")
    public String employeeEditTask(@PathVariable("id") Long id,Model model){

        model.addAttribute("task",taskService.findById(id));
//        model.addAttribute("projects",projectService.findAll());
//        model.addAttribute("employees",userService.findEmployee());  we dont wanna show when we click update, all the projects and all employees. that's why i will go to status.update.html page and delete th:each
        model.addAttribute("statuses",Status.values());
        model.addAttribute("tasks",taskService.findAllTasksByStatusIsNot(Status.COMPLETED));



        return "/task/status-update";
    }






    @PostMapping("/employee/update/{id}")
    public String employeeUpdateTask( TaskDTO task){ // @ModelAttribute("task") bunu koymama gerek yok cunku {id} ile status-update.html'deki {id} eslesiyor.

       // taskService.update(task); i cannot use this , because i cannot update status with this way. because in the update method there is a set method like this :  task.setTaskStatus(foundTask.getTaskStatus());

        taskService.updateStatus(task);


        return "redirect:/task/employee/pending-tasks";
    }

}
