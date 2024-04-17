package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.impl.AbstractMapService;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO,String> {

    void complete(ProjectDTO project); // this is for complete status

    List<ProjectDTO>getCountedListOfProjectDTO(UserDTO manager); // we created this for Project Status
// because i wanna see only project belongs to specific manager. i will design it on the ProjectServiceImpl

}
