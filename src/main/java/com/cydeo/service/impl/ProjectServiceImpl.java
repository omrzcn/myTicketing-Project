package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    private  final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public ProjectDTO save(ProjectDTO user) {

        if (user.getProjectStatus()==null) {
            user.setProjectStatus(Status.OPEN);
        }
        return super.save(user.getProjectCode(), user);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }

    @Override
    public void update(ProjectDTO object) {

//        if (object.getProjectCode() == null){
//            object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
//        } // this is for before save button we need to provide this code for update button


        super.update(object.getProjectCode(), object);
    }

    @Override
    public void complete(ProjectDTO project) { // this is for complete status


            project.setProjectStatus(Status.COMPLETED);

    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        List<ProjectDTO> projectList =
                findAll().stream().
                filter(project ->project.getAssignedManager().equals(manager) ).
                // unfinished and completed project is not in the database (DataGenerator).
                map(project -> {


                    List<TaskDTO> taskList = taskService.findTasksByManager(manager); // we created findTasksByManager() method on TaskServiceImpl. Because projects are belongs to the manager. this is gonna show the task belongs to manager

                    // we need to find completed task by the help of Stream. from Project Create page.
//                    int completeTaskCount = 5;
//                    int unfinishedTaskCounts = 3 ; // these are just example. How im gonna figure out these numbers. This is hard code, just example


                    // we need to find completed task by the help of Stream. from Project Create page.

                    // we need  to put 2 filtered each stream. Because if 1 manager has more than 1 task and their status are different. ?
                    int completeTaskCount =(int)taskList.stream().filter(t->t.getProject().equals(project) && t.getTaskStatus()== Status.COMPLETED).count();
                    int unfinishedTaskCounts = (int) taskList.stream().filter(t->t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETED).count();

                    project.setCompleteTaskCounts(completeTaskCount);
                    project.setUnfinishedTaskCounts(unfinishedTaskCounts);


                    return project;



                }).collect(Collectors.toList());








        return projectList;
    }
}
