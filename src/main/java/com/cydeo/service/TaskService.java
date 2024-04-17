package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long>{ // after TaskDTO , we need to put thing but we dont have anything unique for Task. That's why i created in TaskDTO => private Long id, this is gonna be unique for Task.

    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    List<TaskDTO> findAllTasksByStatus(Status status);
    void updateStatus(TaskDTO task);



}
