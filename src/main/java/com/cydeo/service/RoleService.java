package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


public interface RoleService extends CrudService<RoleDTO,Long> {// search with Long id


    // BELOW CODES ARE BEFORE CREATING CrudService INTERFACE

//    // i will create "save RoleDTO" interface here because service package works with DTO's
//
//    RoleDTO save(RoleDTO user); // why its not "void" , i will explain it later
//
//
//    UserDTO findById(Long id );  // we will find with "id" . Because id is unique
//
//    List<RoleDTO> findAll(); // this is a method we can find all rolesDTOs.
//
//    void deleteById(Long id);


}
