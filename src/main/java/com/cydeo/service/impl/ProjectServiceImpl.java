package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {


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
}
