package com.cydeo.service;

import com.cydeo.dto.TaskDTO;

public interface TaskService extends CrudService<TaskDTO,Long>{ // after TaskDTO , we need to put thing but we dont have anything unique for Task. That's why i created in TaskDTO => private Long id, this is gonna be unique for Task.
}
